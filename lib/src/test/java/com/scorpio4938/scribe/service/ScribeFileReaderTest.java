package com.scorpio4938.scribe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ScribeFileReaderTest {
    private final String txtStringPath = System.getProperty("user.dir") + "/src/test/resources/exampleString.txt";
    private final String txtIntegerPath = System.getProperty("user.dir") + "/src/test/resources/exampleInteger.txt";
    private final String txtStringMixIntegerPath = System.getProperty("user.dir") + "/src/test/resources/exampleInteger.txt";
    private final String txtEmptyPath = System.getProperty("user.dir") + "/src/test/resources/exampleEmpty.txt";
    private final String txtNonExistPath = System.getProperty("user.dir") + "/src/test/resources/exampleNonExist.txt";

    @Test
    void txtStringReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals("Alice\nJay", scribeFileReader.txtStringReader(txtStringPath), "ScribeFileReader.txtStringReader() should return String 'Alice' and 'Jay' from the test file: " + txtStringPath);

        Assertions.assertEquals("", scribeFileReader.txtStringReader(txtEmptyPath), "ScribeFileReader.txtStringReader() should return an empty String from the test file: " + txtEmptyPath);
        Assertions.assertThrows(IOException.class, () -> scribeFileReader.txtStringReader(txtNonExistPath), "ScribeFileReader.txtStringReader() should throw an IOException from the non-exist test file: " + txtNonExistPath);
    }

    @Test
    void txtStringArrayListReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals(List.of("Alice", "Jay"), scribeFileReader.txtStringArrayListReader(txtStringPath), "ScribeFileReader.txtStringArrayListReader() should return String 'Alice' and 'Jay' from the test file: " + txtStringPath);

        Assertions.assertEquals(List.of(), scribeFileReader.txtStringArrayListReader(txtEmptyPath), "ScribeFileReader.txtStringArrayListReader() should return an empty List of String from the test file: " + txtEmptyPath);
        Assertions.assertThrows(IOException.class, () -> scribeFileReader.txtStringArrayListReader(txtNonExistPath), "ScribeFileReader.txtStringArrayListReader() should throw an IOException from the non-exist test file: " + txtNonExistPath);
    }

    @Test
    void txtIntegerArrayListReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        Assertions.assertEquals(List.of(1, 2), scribeFileReader.txtIntegerArrayListReader(txtIntegerPath), "ScribeFileReader.txtIntegerArrayListReader() should return (List.of(1, 2) from the test file: " + txtIntegerPath);
        Assertions.assertEquals(List.of(1, 2), scribeFileReader.txtIntegerArrayListReader(txtStringMixIntegerPath), "ScribeFileReader.txtIntegerArrayListReader() should return (List.of(1, 2) from the test file: " + txtStringMixIntegerPath);

        Assertions.assertEquals(List.of(), scribeFileReader.txtIntegerArrayListReader(txtEmptyPath), "ScribeFileReader.txtIntegerArrayListReader() should return an empty List of Integers from the test file: " + txtEmptyPath);
        Assertions.assertThrows(IOException.class, () -> scribeFileReader.txtIntegerArrayListReader(txtNonExistPath), "ScribeFileReader.txtIntegerArrayListReader() should throw an IOException from the non-exist test file: " + txtNonExistPath);
    }

    @Test
    void txtIntArrayReader() throws IOException {
        ScribeFileReader scribeFileReader = new ScribeFileReader();
        int[] numbers = {1, 2};
        int[] emptys = {};
//        Arrays.setAll(numbers, i -> i + 1);
        Assertions.assertArrayEquals(numbers, scribeFileReader.txtIntArrayReader(txtIntegerPath), "ScribeFileReader.txtIntArrayReader() should return " + Arrays.toString(numbers) + " from the test file: " + txtIntegerPath + ", yet returned:" + Arrays.toString(scribeFileReader.txtIntArrayReader(txtIntegerPath)));
        Assertions.assertArrayEquals(numbers, scribeFileReader.txtIntArrayReader(txtStringMixIntegerPath), "ScribeFileReader.txtIntArrayReader() should return " + Arrays.toString(numbers) + " from the test file: " + txtStringMixIntegerPath + ", yet returned:" + Arrays.toString(scribeFileReader.txtIntArrayReader(txtStringMixIntegerPath)));

        Assertions.assertArrayEquals(emptys, scribeFileReader.txtIntArrayReader(txtEmptyPath), "ScribeFileReader.txtIntArrayReader() should return " + Arrays.toString(emptys) + " from the test file: " + txtEmptyPath + ", yet returned:" + Arrays.toString(scribeFileReader.txtIntArrayReader(txtEmptyPath)));
        Assertions.assertThrows(IOException.class, () -> scribeFileReader.txtIntArrayReader(txtNonExistPath), "ScribeFileReader.txtIntArrayReader() should throw an IOException from the non-exist test file: " + txtNonExistPath);
    }
}
