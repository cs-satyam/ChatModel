package cs.satysm.AiDemo.llm;

import dev.langchain4j.model.chat.ChatModel;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class LlmClientImpl implements Llmclient {

    @Qualifier("gemini")
    private final ChatModel geminiChatModel;
    @Qualifier("ollama")
    private final ChatModel ollamaChatModel;
    @Qualifier("grok")
    private final ChatModel grokChatModel;


    @Override
    public String geminiChat(String message) {
        return geminiChatModel.chat(message);
    }

    @Override
    public String ollamChat(String message) {
        return ollamaChatModel.chat(message);
    }

    // now working grok
    @Override
    public String grokChat(String message) {
        return grokChatModel.chat(message);
    }


}
