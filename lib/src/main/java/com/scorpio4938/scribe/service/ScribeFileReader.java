package com.scorpio4938.scribe.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScribeFileReader {

    /**
     * Reads the content of a file into a String.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
     */
    public String txtStringReader(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}
