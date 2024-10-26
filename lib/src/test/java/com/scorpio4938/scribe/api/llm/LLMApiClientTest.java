package com.scorpio4938.scribe.api.llm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LLMApiClientTest {
    private final boolean call = false; // Whether to use llm

    String LLMCall() throws Exception {
        if (call) {
            LLMApiClient llm = new LLMApiClient(new Providers().getProvider("DEEPSEEK"), null);
            return llm.callLLM("deepseek-chat", "give me a english name");
        }
        return null;
    }

    @Test
    void callLLMTest() throws Exception {
        String result = this.LLMCall();
//        Assertions.assertNotNull(result);
        System.out.print("llm result: " + result + "\n");
    }
}
