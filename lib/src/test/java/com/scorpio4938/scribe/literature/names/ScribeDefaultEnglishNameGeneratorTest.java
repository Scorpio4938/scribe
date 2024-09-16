package com.scorpio4938.scribe.literature.names;

import com.scorpio4938.scribe.service.reader.ScribeFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ScribeDefaultEnglishNameGeneratorTest {
    private final String EngNamePath = "src/test/resources/names/exampleEngNames.txt";

    private List<String> names;

    @Test
    void init() throws IOException {
        names = new ScribeFileReader().txtStringArrayListReader(EngNamePath);
//        System.out.print(names);
        Assertions.assertNotNull(names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);
//        Assertions.assertNotNull(this.names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);
    }

    @Test
    void generatorTest() throws IOException {
        init();
        Assertions.assertNotNull(names, "The name list for testing ScribeDefaultEnglishNameGenerator should not be null: " + EngNamePath);

        ScribeDefaultEnglishNameGenerator generator = new ScribeDefaultEnglishNameGenerator();
        String generatedName = generator.generate(EngNamePath);
        Assertions.assertTrue(names.contains(generatedName), "ScribeDefaultEnglishNameGenerator.generate() should return of name from: " + EngNamePath);
    }
}
