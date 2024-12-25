package com.scorpio4938.scribe.api.llm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LLMApiClientTest {
    private final boolean call = false; // Whether to use llm

    String LLMCall() throws Exception {
        if (call) {
            LLMApiClient llm = new LLMApiClient(new Providers().getProvider("OPENROUTER"), null);
            return llm.callLLM("google/gemini-2.0-flash-exp:free", "give me a english name");
        }
        return null;
    }

    @Test
    void maxTokensTest() {
        LLMApiClient llm = new LLMApiClient(new Providers().getProvider("OPENROUTER"), null);
        Assertions.assertEquals(100, llm.getMaxTokens(), "llm api client show have a default maxtoken of 100");
    }

    @Test
    void setMessageTest() {
        LLMApiClient llm = new LLMApiClient(new Providers().getProvider("OPENROUTER"), null);
        System.out.print("LLM Api client Set Message: " + llm.getSetMessage("google/gemini-2.0-flash-exp:free", "give me a english name") + "\n");
    }

    @Test
    void callLLMTest() throws Exception {
        String result = this.LLMCall();
//        Assertions.assertNotNull(result);
        System.out.print("llm result: " + result + "\n");
    }
}
