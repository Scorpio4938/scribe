package com.scorpio4938.scribe.literature.llm.names;

import org.junit.jupiter.api.Test;

public class ScribeLLMNameGeneratorTest {
    private final boolean call = false; // Whether to use llm

    @Test
    void generateTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generate("OPENROUTER", "google/gemini-exp-1206:free", "give me a english name", null);
        System.out.print("LLM Name basic Generator Test name: " + result + "\n");
    }

    @Test
    void generateNameTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generateName("OPENROUTER", "google/gemini-2.0-flash-exp:free", null, "english");
        System.out.print("LLM Name Generator Test name: " + result + "\n");
    }

    @Test
    void generateFullNameTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generateFullName("OPENROUTER", "google/gemini-2.0-flash-exp:free", null, "english");
        System.out.print("LLM full Name Generator Test name: " + result + "\n");
    }
}
