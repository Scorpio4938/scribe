package com.scorpio4938.scribe.service.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScribeFileReader {
    // There's still the need to test whether the type to throw error: 'throws IOException' is needed in every function.

    /**
     * Reads the content of a txt file into a String.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    // The issue of an extra new line is likely due to the extra newline character (\n) being appended to the StringBuilder when reading the file.
    // To fix this, modify the method to avoid appending the newline character at the end of the file content.
    public String txtStringReader(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (!isFirstLine) {
                    content.append("\n");
                }
                content.append(line);
                isFirstLine = false;
            }
            return content.toString();
        }
    }

    /**
     * Reads the content of a txt file into a String array.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String array.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public List<String> txtStringArrayListReader(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    /**
     * Reads the content of a txt file into an Integer array list.
     *
     * @param filePath The path to the file.
     * @return The content of the file as an Integer array list.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public List<Integer> txtIntegerArrayListReader(String filePath) throws IOException {
        List<Integer> intList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    intList.add(num);
                } catch (NumberFormatException e) {
//                    System.err.println("Skipping non-integer line: " + line);
                }
            }
        }

//        // Convert List<Integer> to int[]
//        int[] intArray = new int[intList.size()];
//        for (int i = 0; i < intList.size(); i++) {
//            intArray[i] = intList.get(i);
//        }

        return intList;
    }

    /**
     * Reads the content of a txt file into an int[] array.
     *
     * @param filePath The path to the file.
     * @return The content of the file as an int[] array.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public int[] txtIntArrayReader(String filePath) throws IOException {
        List<Integer> intList = new ScribeFileReader().txtIntegerArrayListReader(filePath);

        // Convert List<Integer> to int[]
        int[] intArray = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            intArray[i] = intList.get(i);
        }

        return intArray;
    }
}
