package com.scorpio4938.scribe.api.llm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scorpio4938.scribe.service.utils.MapSorter;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LLMRequest {
    private String model;
    private List<Message> messages;

    public LLMRequest(String model, @Nullable List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }

    public LLMRequest.Message createMessage(String role, String content) {
        return new LLMRequest.Message(role, content);
    }

    public String buildMessage(Map<String, String> map) {
        Gson gson = new GsonBuilder().create();

        List<Message> messages = new ArrayList<>();
        Map<String, String> sorted = MapSorter.sortByKeys(map);
//        LLMRequest.Message systemMessage = this.createMessage("system", "You are a helpful assistant.");
//        LLMRequest.Message userMessage = this.createMessage("user", "Tell me a joke about programming.");
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            messages.add(createMessage(entry.getKey(), entry.getValue()));
        }

        return gson.toJson(new LLMRequest(this.model, messages));
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
