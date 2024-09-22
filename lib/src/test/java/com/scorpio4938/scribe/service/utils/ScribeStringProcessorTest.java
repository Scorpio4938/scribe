package com.scorpio4938.scribe.service.utils;

import com.scorpio4938.scribe.service.reader.ScribeFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ScribeStringProcessorTest {
    private final String txtStringPath = "src/test/resources/exampleString.txt";

    @Test
    void joinListTest() throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        Assertions.assertEquals("Alice Jay", ScribeStringProcessor.joinList(reader.txtStringArrayListReader(txtStringPath)));
    }
}
