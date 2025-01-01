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
        Assertions.assertEquals("{\"model\":\"google/gemini-2.0-flash-exp:free\",\"max_tokens\":100,\"messages\":[{\"role\":\"user\",\"content\":\"give me a english name\"}]}", llm.getSetMessage("google/gemini-2.0-flash-exp:free", "give me a english name").toString(), "False LLM Message Setter");
    }

    @Test
    void setMessage1Test() {
        LLMApiClient llm = new LLMApiClient(new Providers().getProvider("OPENROUTER"), null);
//        Assertions.assertEquals("{\"model\":\"google/gemini-2.0-flash-exp:free\",\"messages\":[{\"role\":\"user\",\"content\":\"give me a english name\"}]}", llm.getSetMessage1("google/gemini-2.0-flash-exp:free", "give me a english name"), "False LLM Message Setter");
    }

    @Test
    void callLLMTest() throws Exception {
        String result = this.LLMCall();
//        Assertions.assertNotNull(result);
        System.out.print("llm result: " + result + "\n");
    }
}
