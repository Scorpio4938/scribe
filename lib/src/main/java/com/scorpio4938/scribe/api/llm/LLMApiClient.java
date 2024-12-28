package com.scorpio4938.scribe.api.llm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.scorpio4938.scribe.service.utils.debug.Debugger;

import javax.annotation.Nullable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * llm api client.
 *
 * @since 0.1.1
 */
public class LLMApiClient {
    private Provider provider;
    private int maxTokens;

    // Constructor takes the  provider (OpenAI, Anthropic, etc.) and maxTokens (Default 100)
    public LLMApiClient(Provider provider1, @Nullable Integer maxTokens) {
        this.provider = provider1;
        this.maxTokens = (maxTokens != null) ? maxTokens : 100;
    }

    private JsonObject setMessage(String model, String userMessage) {
        JsonObject json = new JsonObject();
        json.addProperty("model", this.provider.getModel(model));
        json.addProperty("max_tokens", this.maxTokens);

        JsonArray messages = new JsonArray();
        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", userMessage);
        messages.add(message);

        json.add("messages", messages);
        Debugger.log("message" + json.toString());
        return json;
    }

    private String setMessage1(String model, String userMessage) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(new LLMRequest(this.provider.getModel(model), List.of(new LLMRequest.Message("user", userMessage))));
    }

    // Send the request based on provider and model
    private String sendRequest(JsonObject requestBody) throws Exception {
        // Get the appropriate API URL based on the provider
        String apiUrl = this.provider.getUrl();

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + this.provider.getKey())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Debug
        Debugger.log("Request Headers: " + request.headers());
        Debugger.log("Response body: " + response.body());

        // Return the response body
        return response.body();
    }

    // Send the request based on provider and model
    private String sendRequest1(String requestBody) throws Exception {
        // Get the appropriate API URL based on the provider
        String apiUrl = this.provider.getUrl();

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + this.provider.getKey())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Debug
        Debugger.log("Request Headers: " + request.headers());
        Debugger.log("Response body: " + response.body());

        // Return the response body
        return response.body();
    }

    /**
     * Call the LLM with the given model and message.
     *
     * @param model   The model to use.
     * @param message The message to send to the LLM.
     * @return The response from the LLM.
     * @throws Exception If there is an error sending the request.
     */
    public String callLLM(String model, String message) throws Exception {
        return this.sendRequest1(this.setMessage1(model, message));
    }

    // Getters

    /**
     * Get the max tokens.
     *
     * @return The max tokens.
     */
    public int getMaxTokens() {
        return this.maxTokens;
    }

    /**
     * Get the set message.
     *
     * @param model   The model to use.
     * @param message The message to send to the LLM.
     * @return The set message.
     */
    public JsonObject getSetMessage(String model, String message) {
        return this.setMessage(model, message);
    }

    /**
     * Get the set message.
     *
     * @param model   The model to use.
     * @param message The message to send to the LLM.
     * @return The set message.
     */
    public String getSetMessage1(String model, String message) {
        return this.setMessage1(model, message);
    }
}
