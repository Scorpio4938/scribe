package com.scorpio4938.scribe.literature.llm.names;

import com.scorpio4938.scribe.api.llm.LLMApiClient;
import com.scorpio4938.scribe.api.llm.Provider;
import com.scorpio4938.scribe.api.llm.Providers;
import com.scorpio4938.scribe.literature.llm.LitLLMGenerator;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;

public class ScribeLLMNameGenerator implements LitLLMGenerator {
    public ScribeLLMNameGenerator() {

    }

    @Override
    public void init() {

    }

    @Override
    public String generate(String provider, String model, String message, @Nullable Integer maxTokens) throws Exception {
        LLMApiClient llm = new LLMApiClient(new Providers().getProvider(provider), maxTokens);
        return llm.callLLM(model, message);
    }

    @Override
    public String compileMessage(String language, String request) {
        return "give me a " + language + request;
    }

    public String generateName(String provider, String model, @Nullable Integer maxTokens, String language) throws Exception {
        return this.generate(provider, model, this.compileMessage(language, "name"), maxTokens);
    }

    public String generateFullName(String provider, String model, @Nullable Integer maxTokens, String language) throws Exception {
        return this.generate(provider, model, this.compileMessage(language, "full name"), maxTokens);
    }
}
