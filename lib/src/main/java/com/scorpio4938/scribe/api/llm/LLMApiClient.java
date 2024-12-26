package com.scorpio4938.scribe.api.llm;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.annotation.Nullable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        json.addProperty("model", provider.getModel(model));
        json.addProperty("max_tokens", this.maxTokens);

        JsonArray messages = new JsonArray();
        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", userMessage);
        messages.add(message);

        json.add("messages", messages);
        return json;
    }

    // Send the request based on provider and model
    public String sendRequest(JsonObject requestBody) throws Exception {
        // Get the appropriate API URL based on the provider
        String apiUrl = this.provider.getUrl();
        System.out.println("URL: " + apiUrl);

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
        System.out.println("----------debug----------");
        System.out.println("Request Method: " + request.method());
        System.out.println("Request URI: " + request.uri());
        System.out.println("Request Headers: " + request.headers());
        System.out.println("Request: " + request);
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());
//        System.out.println("Response: " + response);
        System.out.println("-------------------------");

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
        return this.sendRequest(this.setMessage(model, message));
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
}
