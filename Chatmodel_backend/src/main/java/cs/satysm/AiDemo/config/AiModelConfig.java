package cs.satysm.AiDemo.config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AiModelConfig {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Value("${groq.api.key}")
    private String groqApiKey;

    @Value("${ollama.base-url:http://localhost:11434}")
    private String ollamaBaseUrl;


    @Bean("gemini")
    public ChatModel geminiChatModel() {
        return GoogleAiGeminiChatModel.builder()
                .apiKey(geminiApiKey)
                .modelName("gemini-3.6-flash")
                .build();
    }

    @Bean("ollama")
    public ChatModel ollamaChatModels() {
        return OllamaChatModel.builder()
                .baseUrl(ollamaBaseUrl)
                .modelName("medgemma:4b")
                .temperature(0.5)
                .timeout(Duration.ofSeconds(60))
                .build();
    }

    // grok is not working
    @Bean("grok")
    public ChatModel grokChatModel() {
        return OpenAiChatModel.builder()
                .apiKey(groqApiKey)
                .modelName("grok-3-mini")
                .build();
    }
}