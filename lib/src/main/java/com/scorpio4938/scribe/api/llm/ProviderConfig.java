package com.scorpio4938.scribe.api.llm;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.*;

public class ProviderConfig {
    private List<Provider> providers = new ArrayList<>();

    public ProviderConfig() {
        this.config();
    }

    private void config() {
        this.addProvider("DEEPSEEK", "https://api.deepseek.com", "DEEPSEEK_API_KEY", List.of("deepseek-chat", "deepseek-coder"));
        this.addProvider("MOONSHOT", "https://api.moonshot.cn/v1", "MOONSHOT_API_KEY", List.of("moonshot-v1-8k", "moonshot-v1-32k", "moonshot-v1-128k"));
    }

    // Add a new provider and its corresponding API key
    public void addProvider(String provider, String url, String keyName, List<String> models) {
        Dotenv dotenv = Dotenv.load();
        this.providers.add(new Provider(provider, url, dotenv.get(keyName), models));
    }

    // Get the API key for a given provider
//    public String getApiKey(String provider) {
//        String apiKey = PROVIDERS.get(provider.toLowerCase());
//        if (apiKey == null) {
//            throw new IllegalArgumentException("API key for provider '" + provider + "' not found.");
//        }
//        return apiKey;
//    }

    public Provider getProvider(String provider) {
        for (Provider provider1 : providers) {
            if (provider1.getProvider().equals(provider)) {
                return provider1;
            }
        }
        throw new IllegalArgumentException("Unsupported provider: " + provider);
    }

    // Get all available providers
//    public Map<String, String> getProviders() {
//        return PROVIDERS;
//    }
}
