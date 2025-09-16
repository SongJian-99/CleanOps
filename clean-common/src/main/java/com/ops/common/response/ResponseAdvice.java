package com.ops.common.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ops.common.domain.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局响应处理器
 * 统一处理返回结果，将所有返回结果包装成Result对象
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 是否支持处理该返回值
     *
     * @param returnType    方法参数
     * @param converterType 消息转换器类型
     * @return 是否支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 获取返回值类型
        Class<?> returnTypeClass = returnType.getParameterType();

        // 如果已经是Result类型，则不处理
        if (Result.class.isAssignableFrom(returnTypeClass)) {
            return false;
        }

        // 如果返回值是String类型，也不处理（避免类型转换问题）
        if (String.class.isAssignableFrom(returnTypeClass)) {
            return false;
        }

        // 其他情况都处理
        return true;
    }

    /**
     * 处理返回值
     *
     * @param body                  原始返回值
     * @param returnType            方法参数
     * @param selectedContentType   选择的内容类型
     * @param selectedConverterType 选择的转换器类型
     * @param request               请求
     * @param response              响应
     * @return 处理后的返回值
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 如果返回值为null，返回成功的空结果
        if (body == null) {
            return Result.success();
        }

        // 如果返回值已经是Result类型，直接返回
        if (body instanceof Result) {
            return body;
        }

        // 其他情况统一包装成Result.success
        return Result.success(body);
    }
}