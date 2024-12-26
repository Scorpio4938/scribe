package com.scorpio4938.scribe.api.llm;

import java.util.List;

public class LLMRequest {
    private String model;
    private List<Message> messages;

    public LLMRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        // Getters and setters if needed
    }
}
