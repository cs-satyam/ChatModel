package cs.satysm.AiDemo.controller;

import cs.satysm.AiDemo.dto.ChatRequest;
import cs.satysm.AiDemo.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/gemini")
    public String askGemini(@RequestBody ChatRequest chatRequest){
        return chatService.geminiCHat(chatRequest);
    }

    @PostMapping("/ollama")
    public String askOllama(@RequestBody ChatRequest chatRequest){
        return chatService.ollamaChat(chatRequest);
    }

    @PostMapping("/grok")
    public String askGrok(@RequestBody ChatRequest chatRequest){ return chatService.grokChat(chatRequest);}
}
