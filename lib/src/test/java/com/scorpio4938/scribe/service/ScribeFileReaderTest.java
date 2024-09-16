package com.scorpio4938.scribe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ScribeFileReaderTest {
    private final String txtString = System.getProperty("user.dir") + "/src/test/resources/exampleString.txt";
    private final String txtInteger = System.getProperty("user.dir") + "/src/test/resources/exampleInteger.txt";

    @Test
    void txtStringReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals("Alice\nJay", scribeFileReader.txtStringReader(txtString), "ScribeFileReader.txtStringReader() should return String 'Alice' and 'Jay' from the test file: " + txtString);
    }

    @Test
    void txtStringArrayListReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals(List.of("Alice", "Jay"), scribeFileReader.txtStringArrayListReader(txtString), "ScribeFileReader.txtStringArrayListReader() should return String 'Alice' and 'Jay' from the test file: " + txtString);
    }

    @Test
    void txtIntegerArrayListReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals(List.of(1, 2), scribeFileReader.txtIntegerArrayListReader(txtInteger), "ScribeFileReader.txtIntegerArrayListReader() should return (List.of(1, 2) from the test file: " + txtInteger);
    }

    @Test
    void txtIntArrayReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        int[] numbers = {1, 2};
//        Arrays.setAll(numbers, i -> i + 1);
        Assertions.assertArrayEquals(numbers, scribeFileReader.txtIntArrayReader(txtInteger), "ScribeFileReader.txtIntArrayReader() should return " + Arrays.toString(numbers) + " from the test file: " + txtInteger + ", yet returned:" + Arrays.toString(scribeFileReader.txtIntArrayReader(txtInteger)));
    }
}
