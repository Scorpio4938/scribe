package com.scorpio4938.scribe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ScribeFileReaderTest {
    private final String txtString = System.getProperty("user.dir") + "/src/test/java/resources/exampleString.txt";

    @Test
    void txtStringReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals("Alice", scribeFileReader.txtStringReader(txtString), "ScribeFileReader.txtStringReader() should return String 'Alice' from the test file: " + txtString);
    }
}
