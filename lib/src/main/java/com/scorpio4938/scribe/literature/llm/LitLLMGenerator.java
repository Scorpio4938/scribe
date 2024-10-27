package com.scorpio4938.scribe.literature.llm;

import com.scorpio4938.scribe.api.llm.Provider;
import com.scorpio4938.scribe.literature.LitGenerator;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;

public interface LitLLMGenerator {

    void init();

    String generate(String provider, String model, String message, @Nullable Integer maxTokens) throws Exception;

    String compileMessage(String language, String request);
}
