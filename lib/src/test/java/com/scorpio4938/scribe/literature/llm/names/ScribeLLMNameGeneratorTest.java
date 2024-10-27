package com.scorpio4938.scribe.literature.llm.names;

import org.junit.jupiter.api.Test;

public class ScribeLLMNameGeneratorTest {
    @Test
    void generateTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generate("MOONSHOT", "moonshot-v1-8k", "give me a english name", null);
        System.out.print("LLM Name basic Generator Test name: " + result + "\n");
    }

    @Test
    void generateNameTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generateName("DEEPSEEK", "deepseek-chat", null, "english");
        System.out.print("LLM Name Generator Test name: " + result + "\n");
    }

    @Test
    void generateFullNameTest() throws Exception {
        ScribeLLMNameGenerator llmNameGenerator = new ScribeLLMNameGenerator();
        String result = llmNameGenerator.generateFullName("DEEPSEEK", "deepseek-chat", null, "english");
        System.out.print("LLM full Name Generator Test name: " + result + "\n");
    }
}
