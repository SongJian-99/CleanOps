package com.ops.langchain.controller;

import com.ops.common.domain.Result;
import com.ops.langchain.controller.dto.ModelProviderDTO;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Cleaner
 * Date: 2025/9/11 09:48
 **/
@RestController
@RequestMapping("/model")
public class ModelController {

    @GetMapping("/test")
    public void executeModel() {
        ChatRequest chatRequest = ChatRequest.builder()
                .messages(UserMessage.from("你是哪个模型？"))
                .build();

//        OpenAiChatModel chatModel = OpenAiChatModel.builder()
//                .modelName("deepseek-chat")
//                .apiKey("sk-ec98092d46b3440284873ecebd78f668")
//                .baseUrl("https://api.deepseek.com")
//                .build();

        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .modelName("qwen-plus")
                .apiKey("sk-e1fc1eb43d10422b8ca700c55c0e7a1a")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();

        ChatResponse chatResponse = chatModel.chat(chatRequest);
        System.out.println("chatResponse = " + chatResponse);
    }

    @PostMapping("/backend/add")
    public Result<Void> addModel(@RequestBody ModelProviderDTO modelProviderDTO) {

        return Result.success();
    }
}
