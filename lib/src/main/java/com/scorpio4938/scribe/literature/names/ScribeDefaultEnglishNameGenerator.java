package com.scorpio4938.scribe.literature.names;

import com.scorpio4938.scribe.literature.LitGenerator;
import com.scorpio4938.scribe.service.reader.ScribeFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ScribeDefaultEnglishNameGenerator implements LitGenerator {
    private final String DefaultFirstNamePath = "lib/src/main/resources/names/uk_male_first_names.txt";

    @Override
    public String generate(String filepath) throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        Random random = new Random();
        List<String> nameList = reader.txtStringArrayListReader(filepath);
        return nameList.get(random.nextInt(nameList.size()));
    }

    public String defaultFirstNameGenerator() throws IOException {
        return this.generate(DefaultFirstNamePath);
    }
}
