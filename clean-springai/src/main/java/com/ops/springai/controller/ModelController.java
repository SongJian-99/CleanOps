package com.ops.springai.controller;

import com.ops.common.domain.Result;
import jakarta.annotation.Resource;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:Cleaner
 * Date: 2025/9/11 09:48
 **/
@RestController
@RequestMapping("/model")
public class ModelController {

    @Resource
    private DeepSeekChatModel deepSeekChatModel;

    private final String DEEPSEEK_API_KEY = "sk-60ab04692d544c9b91d2986a29518926";
    private final String DEEPSEEK_API_URL = "https://api.deepseek.ai/";

    @GetMapping("/test")
    public Result<String> executeModel() {
        try {
            String hello = deepSeekChatModel.call("hello");
            System.out.println("hello = " + hello);
            return Result.success(hello);
        } catch (Exception e) {
            return Result.error("调用模型失败: " + e.getMessage());
        }
    }
}