package cs.satysm.AiDemo.llm;

import dev.langchain4j.model.chat.ChatModel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class LlmClientImpl implements Llmclient {

    private final ChatModel geminiChatModel;
    private final ChatModel ollamaChatModel;

    public LlmClientImpl(
            @Qualifier("gemini") ChatModel geminiChatModel,
            @Qualifier("ollama") ChatModel ollamaChatModel,
            @Qualifier("grok")ChatModel grokChatModel   ) {
        this.geminiChatModel=geminiChatModel;
        this.ollamaChatModel=ollamaChatModel;

    }


    @Override
    public String geminiChat(String message) {
        return geminiChatModel.chat(message);
    }

    @Override
    public String ollamChat(String message) {
        return ollamaChatModel.chat(message);
    }

    @Override
    public String grokChat(String message) {
        return geminiChatModel.chat(message);
    }


}
