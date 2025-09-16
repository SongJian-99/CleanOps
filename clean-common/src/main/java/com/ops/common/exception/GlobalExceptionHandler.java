package com.ops.common.exception;

import com.ops.common.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.net.ssl.SSLHandshakeException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理业务异常
     *
     * @param e 业务异常
     * @return Result
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        logger.error("业务异常，错误码：{}，错误信息：{}", e.getCode(), e.getMessage(), e);
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理SSL握手异常
     *
     * @param e SSL握手异常
     * @return Result
     */
    @ExceptionHandler(SSLHandshakeException.class)
    public Result<Void> handleSSLHandshakeException(SSLHandshakeException e) {
        logger.error("SSL握手异常：{}", e.getMessage(), e);
        return Result.error(500, "SSL连接异常，请检查网络或联系管理员");
    }

    /**
     * 处理参数异常
     *
     * @param e 参数异常
     * @return Result
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("参数异常：{}", e.getMessage(), e);
        return Result.error(400, "参数错误：" + e.getMessage());
    }

    /**
     * 处理空指针异常
     *
     * @param e 空指针异常
     * @return Result
     */
    @ExceptionHandler(NullPointerException.class)
    public Result<Void> handleNullPointerException(NullPointerException e) {
        logger.error("空指针异常：{}", e.getMessage(), e);
        return Result.error(500, "系统内部错误，请联系管理员");
    }

    /**
     * 处理其他异常
     *
     * @param e 其他异常
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        logger.error("系统异常：{}", e.getMessage(), e);
        return Result.error(500, "系统内部错误，请联系管理员");
    }
}