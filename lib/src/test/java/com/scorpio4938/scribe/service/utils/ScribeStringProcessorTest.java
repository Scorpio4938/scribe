package com.scorpio4938.scribe.service.utils;

import com.scorpio4938.scribe.service.reader.ScribeFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ScribeStringProcessorTest {
    private final String txtStringPath = "src/test/resources/exampleString.txt";

    @Test
    void joinListTest() throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        Assertions.assertEquals("Alice Jay", ScribeStringProcessor.joinList(reader.txtStringArrayListReader(txtStringPath)), "ScribeStringProcessor.joinList should join two list of string using black");
    }

    @Test
    void hyphenateTest() throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        List<String> read = reader.txtStringArrayListReader(txtStringPath);
        Assertions.assertEquals("Alice-Jay", ScribeStringProcessor.hyphenate(read.get(0), read.get(1)), "ScribeStringProcessor.hyphenate() should join two list of string using hyphen");
        Assertions.assertEquals(List.of("Alice-Jay"), ScribeStringProcessor.hyphenate(read), "ScribeStringProcessor.hyphenate() should join two list of string using hyphen");
        Assertions.assertEquals(List.of("Alice-Jay"), ScribeStringProcessor.hyphenate(List.of(read.get(0)), List.of(read.get(1))), "ScribeStringProcessor.hyphenate() should join two list of string using hyphen");

    }
}
