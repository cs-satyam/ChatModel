package cs.satysm.AiDemo.service;

import cs.satysm.AiDemo.dto.ChatRequest;
import cs.satysm.AiDemo.llm.LlmClientImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final LlmClientImpl llmClient;

    public String geminiCHat(ChatRequest chatRequest){
        return llmClient.geminiChat(chatRequest.getMessage());
    }

    public String ollamaChat(ChatRequest chatRequest){
        return  llmClient.ollamChat(chatRequest.getMessage());
    }
    public  String grokChat(ChatRequest chatRequest){
        return llmClient.grokChat(chatRequest.getMessage());
    }
}
