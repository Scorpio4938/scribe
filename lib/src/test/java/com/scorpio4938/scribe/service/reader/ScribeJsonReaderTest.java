package com.scorpio4938.scribe.service.reader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ScribeJsonReaderTest {
    private final String JsonPath = System.getProperty("user.dir") + "/src/test/resources/exampleJson.json";
    private final String JsonArrayPath = System.getProperty("user.dir") + "/src/test/resources/exampleArray.json";

    @Test
    public void readJsonTest() throws IOException {
        ScribeJsonReader jsonReader = new ScribeJsonReader();
        JSONObject jsonObject = jsonReader.readJson(JsonPath);

        Assertions.assertNotNull(jsonObject, "ScribeJsonReader.readJson() should return a not null object: " + JsonPath);
        Assertions.assertEquals("Alice", jsonObject.getString("fir_name"), "ScribeJsonReader.readJson() should return the 'fir_name': " + JsonPath);
        Assertions.assertEquals("Jay", jsonObject.getString("las_name"), "ScribeJsonReader.readJson() should return the 'las_name': " + JsonPath);
    }

    @Test
    public void readJsonArrayTest() throws IOException {
        ScribeJsonReader jsonReader = new ScribeJsonReader();
        JSONArray jsonArray = jsonReader.readJsonArray(JsonArrayPath);

        Assertions.assertNotNull(jsonArray, "ScribeJsonReader.readJsonArray() should return a not null array: " + JsonArrayPath);
        Assertions.assertEquals(2, jsonArray.length(), "ScribeJsonReader.readJsonArray() should return a number length 2 of two: " + JsonArrayPath);
        Assertions.assertEquals("Alice", jsonArray.getJSONObject(0).getString("fir_name"), "ScribeJsonReader.readJsonArray() should return the 'fir_name' of the index 0 object in the array: " + JsonArrayPath);
        Assertions.assertEquals("Jay", jsonArray.getJSONObject(0).getString("las_name"), "ScribeJsonReader.readJsonArray() should return the 'las_name'' of the index 0 object in the array: " + JsonArrayPath);
        Assertions.assertEquals("Brian", jsonArray.getJSONObject(1).getString("fir_name"), "ScribeJsonReader.readJsonArray() should return the 'fir_name'' of the index 1 object in the array: " + JsonArrayPath);
        Assertions.assertEquals("William", jsonArray.getJSONObject(1).getString("las_name"), "ScribeJsonReader.readJsonArray() should return the 'las_name'' of the index 1 object in the array: " + JsonArrayPath);
    }
}
