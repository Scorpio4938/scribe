package com.scorpio4938.scribe.service.reader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class ScribeJsonReader {

    /**
     * Reads the content of a json file into a JsonObject.
     *
     * @param filePath The path to the file.
     * @return The content of the json file into a JsonObject.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public JSONObject readJson(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONTokener tokener = new JSONTokener(fileReader);
            return new JSONObject(tokener);
        }
    }

    /**
     * Reads the content of a json file into a JsonArray.
     *
     * @param filePath The path to the file.
     * @return The content of the json file into a JsonArray.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public JSONArray readJsonArray(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONTokener tokener = new JSONTokener(fileReader);
            return new JSONArray(tokener);
        }
    }
}
