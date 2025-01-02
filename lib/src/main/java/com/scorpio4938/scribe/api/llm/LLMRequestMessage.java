package com.scorpio4938.scribe.api.llm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.scorpio4938.scribe.service.utils.MapSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LLMRequestMessage {

    public LLMRequestMessage() {

    }

    /**
     * Builds a JSON object for the LLM request.
     *
     * @return The JSON object for the LLM request.
     */
    public JsonObject setJsonMessage(String model, int maxTokens, String userMessage) {
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

//    private String gsonMessage(Provider provider, String model, String userMessage) {
//        Gson gson = new GsonBuilder().create();
//        return gson.toJson(new LLMRequest(provider.getModel(model), List.of(new LLMRequest.Message("user", userMessage))));
//    }
//
//    public String setBody() {
//        // Construct the JSON payload
//        Map<String, Object> requestBody = Map.of(
//                "model", "gpt-4", // Replace with the model you want to use
//                "messages", new Object[] {
//                        Map.of("role", "system", "content", "You are a helpful assistant."),
//                        Map.of("role", "user", "content", "What is Java?")
//                }
//        );
//
//        // Convert payload to JSON
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonRequestBody = mapper.writeValueAsString(requestBody);
//        return  jsonRequestBody;
//    }

//    public static class Message {
//        private String model;
//        private List<Message> messages;
//        private String role;
//        private String content;
//
//        public Message(String model, List<Message> messages) {
//            this.model = model;
//            this.messages = messages;
//        }
//
//        public Message(String role, String content) {
//            this.role = role;
//            this.content = content;
//        }
//
//        // Getters and setters if needed
//    }
}
