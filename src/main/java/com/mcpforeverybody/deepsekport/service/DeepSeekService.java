package com.mcpforeverybody.deepsekport.service;

import com.mcpforeverybody.deepsekport.config.DeepSeekProperties;
import com.mcpforeverybody.deepsekport.dto.ChatRequest;
import com.mcpforeverybody.deepsekport.dto.ChatResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.stereotype.Service;

@Service
public class DeepSeekService {

    private final ChatModel chatModel;
    private final DeepSeekProperties properties;

    public DeepSeekService(ChatModel chatModel, DeepSeekProperties properties) {
        this.chatModel = chatModel;
        this.properties = properties;
    }

    public ChatResponse processChat(ChatRequest request) {
        // Create user message
        UserMessage userMessage = new UserMessage(request.getMessage());
        
        // Create prompt
        Prompt prompt = new Prompt(userMessage);
        
        // Call the model
        org.springframework.ai.chat.model.ChatResponse response = chatModel.call(prompt);
        
        // Build response - simplified approach
        // For Spring AI 1.0.1, use getText() instead of getContent()
        String content = response.getResult().getOutput().getText();
        return new ChatResponse(
            content,
            properties.getModel(),
            null
        );
    }
}
