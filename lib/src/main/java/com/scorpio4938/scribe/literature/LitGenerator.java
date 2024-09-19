package com.scorpio4938.scribe.literature;

import java.io.IOException;

public interface LitGenerator {
    // This is the interface for all literal generators.
    // Includes main functions.

    String generate(String filePath) throws IOException;
}
