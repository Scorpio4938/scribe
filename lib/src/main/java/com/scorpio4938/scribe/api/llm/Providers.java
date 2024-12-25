package com.scorpio4938.scribe.api.llm;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.*;

/**
 * List of all the default llm providers (can add customs providers).
 *
 * @since 0.1.1
 */
public class Providers {
    private List<Provider> providers = new ArrayList<>();

    public Providers() {
        this.config();
    }

    private void config() {
        this.addProvider("DEEPSEEK", "https://api.deepseek.com", "DEEPSEEK_API_KEY", List.of("deepseek-chat", "deepseek-coder"));
        this.addProvider("MOONSHOT", "https://api.moonshot.cn/v1", "MOONSHOT_API_KEY", List.of("moonshot-v1-8k", "moonshot-v1-32k", "moonshot-v1-128k"));
        this.addProvider("OPENROUTER", "https://openrouter.ai/api/v1", "OPEN_ROUTER_API_KEY", List.of("google/gemini-exp-1206:free", "google/gemini-2.0-flash-exp:free"));
    }

    // Add a new provider and its corresponding API key
    public void addProvider(String provider, String url, String keyName, List<String> models) {
        Dotenv dotenv = Dotenv.load();
        this.providers.add(new Provider(provider, url, dotenv.get(keyName), models));
    }

    // Get the specified provider
    public Provider getProvider(String provider) {
        for (Provider provider1 : providers) {
            if (provider1.getProvider().equals(provider)) {
                return provider1;
            }
        }
        throw new IllegalArgumentException("Unsupported provider: " + provider);
    }

    // Get all available providers
    public List<Provider> getProviders() {
        return this.providers;
    }
}
