package com.scorpio4938.scribe.literature;

import java.io.IOException;
import java.util.List;

public interface LitGenerator {
    // This is the interface for all literal generators.
    // Includes main functions.

    void init();

    List<String> generate(String filePath) throws IOException;
}
