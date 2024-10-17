package com.scorpio4938.scribe.api.llm;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;

public class ProviderConfig {
    private Map<String, String> providerApiKeys;

    public ProviderConfig() {
        this.providerApiKeys = new HashMap<>();
        this.config();
    }

    private void config() {
        Dotenv dotenv = Dotenv.load();
        this.addProvider("openai", dotenv.get("OPENAI_API_KEY"));
        this.addProvider("anthropic", dotenv.get("ANTHROPIC_API_KEY"));
    }

    // Add a new provider and its corresponding API key
    public void addProvider(String provider, String apiKey) {
        providerApiKeys.put(provider.toLowerCase(), apiKey);
    }

    // Get the API key for a given provider
    public String getApiKey(String provider) {
        String apiKey = providerApiKeys.get(provider.toLowerCase());
        if (apiKey == null) {
            throw new IllegalArgumentException("API key for provider '" + provider + "' not found.");
        }
        return apiKey;
    }

    // Get all available providers
    public Map<String, String> getProviders() {
        return providerApiKeys;
    }
}
