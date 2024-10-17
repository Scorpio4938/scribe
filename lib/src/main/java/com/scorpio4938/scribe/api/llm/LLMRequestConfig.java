package com.scorpio4938.scribe.api.llm;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LLMRequestConfig {
    private String model;
    private int maxTokens;
    private String userMessage;

    public LLMRequestConfig(String model, int maxTokens, String userMessage) {
        this.model = model;
        this.maxTokens = maxTokens;
        this.userMessage = userMessage;
    }

    public JsonObject buildRequestJson() {
        JsonObject json = new JsonObject();
        json.addProperty("model", model);
        json.addProperty("max_tokens", maxTokens);

        JsonArray messages = new JsonArray();
        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", userMessage);
        messages.add(message);

        json.add("messages", messages);
        return json;
    }
}
