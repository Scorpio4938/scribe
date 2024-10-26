package com.scorpio4938.scribe.api.llm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProvidersTest {
    @Test
    void getProvider() {
        Providers providers = new Providers();
        Assertions.assertThrows(IllegalArgumentException.class, () -> providers.getProvider("a"));
    }
}
