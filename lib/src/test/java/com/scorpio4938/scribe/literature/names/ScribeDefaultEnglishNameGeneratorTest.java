package com.scorpio4938.scribe.literature.names;

import com.scorpio4938.scribe.service.reader.ScribeFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ScribeDefaultEnglishNameGeneratorTest {
    private final String EngNamePath = "src/test/resources/names/exampleEngNames.txt";

//    private List<String> names;

    List<String> readExampleList() throws IOException {
//        System.out.print(names);
//        Assertions.assertNotNull(names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);
//        Assertions.assertNotNull(this.names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);
        return new ScribeFileReader().txtStringArrayListReader(EngNamePath);
    }

    @Test
    void generateTest() throws IOException {
//        readExampleList();
//        Assertions.assertNotNull(names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);
        ScribeDefaultEnglishNameGenerator generator = new ScribeDefaultEnglishNameGenerator();
        String generatedName = generator.generate(EngNamePath);
        Assertions.assertTrue(readExampleList().contains(generatedName), "ScribeDefaultEnglishNameGenerator.generate(filePath) should return of name from: " + EngNamePath);
    }

    @Test
    void generateWithNumTest() throws IOException {
        ScribeDefaultEnglishNameGenerator generator = new ScribeDefaultEnglishNameGenerator();
        String generatedName = generator.generate(EngNamePath);
        List<String> generatedName2 = generator.generate(EngNamePath, 2);
        System.out.print(String.join(" ", generatedName2) + "\n");
        Assertions.assertTrue(readExampleList().contains(generatedName), "ScribeDefaultEnglishNameGenerator.generate(filePath, num) should return of name from: " + EngNamePath);
//        Assertions.assertTrue(readExampleList().contains(generatedName2), "ScribeDefaultEnglishNameGenerator.generate(filePath, num) should return of name from: " + EngNamePath);
        Assertions.assertEquals(2, generatedName2.size(), "ScribeDefaultEnglishNameGenerator.generate(filePath, num) should return 2 name from: " + EngNamePath);
        Assertions.assertTrue(readExampleList().contains(generatedName2.get(0)), "ScribeDefaultEnglishNameGenerator.generate(filePath, num) should return a number of name from: " + EngNamePath);
        Assertions.assertTrue(readExampleList().contains(generatedName2.get(1)), "ScribeDefaultEnglishNameGenerator.generate(filePath, num) should return a number of name from: " + EngNamePath);
    }

    @Test
    void generateDefaultFirstNameTest() throws IOException {
        ScribeDefaultEnglishNameGenerator generator = new ScribeDefaultEnglishNameGenerator();
        String generatedName = generator.generateDefaultFirstName();
        System.out.print(generatedName + "\n");
        Assertions.assertNotNull(generatedName, "ScribeDefaultEnglishNameGenerator.generateDefaultFirstName() should not be return null from its default file path.");
    }

    @Test
    void generateDefaultMiddleNameTest() throws IOException {
        ScribeDefaultEnglishNameGenerator generator = new ScribeDefaultEnglishNameGenerator();
        Assertions.assertEquals(1, generator.generateDefaultMiddleName().size(), "ScribeDefaultEnglishNameGenerator.generateDefaultMiddleName() should return 1 middle name.");
        Assertions.assertEquals(2, generator.generateDefaultMiddleName(2).size(), "ScribeDefaultEnglishNameGenerator.generateDefaultMiddleName() should return a number of middle name.");
    }
}