package com.scorpio4938.scribe.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScribeFileReader {

    /**
     * Reads the content of a txt file into a String.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
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
}
