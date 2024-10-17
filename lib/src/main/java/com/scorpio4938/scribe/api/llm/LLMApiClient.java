package com.scorpio4938.scribe.api.llm;

import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LLMApiClient {
    private String apiKey;
    private String provider;

    // Constructor takes the API key and the provider name (OpenAI, Anthropic, etc.)
    public LLMApiClient(String apiKey, String provider) {
        this.apiKey = apiKey;
        this.provider = provider;
    }

    // Get API URL based on the provider
    private String getApiUrl(String model) {
        switch (provider.toLowerCase()) {
            case "openai":
                return "https://api.openai.com/v1/chat/completions";
            case "anthropic":
                return "https://api.anthropic.com/v1/complete"; // Example URL for Anthropic
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }

    // Send the request based on provider and model
    public String sendRequest(String model, JsonObject requestBody) throws Exception {
        // Get the appropriate API URL based on the provider
        String apiUrl = getApiUrl(model);

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        return response.body();
    }
}
