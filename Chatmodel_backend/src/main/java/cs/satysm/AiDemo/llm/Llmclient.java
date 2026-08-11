package cs.satysm.AiDemo.llm;

public interface Llmclient {

     String geminiChat(String message);
     String ollamChat(String message);
     String grokChat(String message);
}
