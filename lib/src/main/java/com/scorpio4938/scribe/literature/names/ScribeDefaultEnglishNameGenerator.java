package com.scorpio4938.scribe.literature.names;

import com.scorpio4938.scribe.literature.LitGenerator;
import com.scorpio4938.scribe.service.reader.ScribeFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ScribeDefaultEnglishNameGenerator implements LitGenerator {
    private String DefaultFirstNamePath = "src/main/resources/names/uk_male_first_names.txt";
    private String DefaultLastNamePath = "src/main/resources/names/uk_male_last_names.txt";
    private String DefaultMiddleNamePath = "src/main/resources/names/uk_male_middle_names.txt";

    public ScribeDefaultEnglishNameGenerator() {

    }

    /**
     * Generate a random single name from the path given.
     *
     * @param filePath The path to the file.
     * @return A random single name.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    @Override
    public String generate(String filePath) throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        Random random = new Random();
        List<String> nameList = reader.txtStringArrayListReader(filePath);
        return nameList.get(random.nextInt(nameList.size()));
    }

    /**
     * Generate a number of random single name from the path given.
     *
     * @param filePath The path to the file.
     * @param num      The number of name needed.
     * @return A number of random single name.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public String generate(String filePath, int num) throws IOException {
        StringBuilder name = new StringBuilder();
        String temp = "";
        for (int i = 0; i < num - 1; i++) {
            String generated = generate(filePath);
            if (!generated.equals(temp)) {
                name.append(generated);
                temp = generated;
            } else {
                i -= 1;
            }
        }
        return name.toString();
    }

    /**
     * Generate a random first name from the default path.
     *
     * @return A random first name.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public String generateDefaultFirstName() throws IOException {
        return generate(DefaultFirstNamePath);
    }

    /**
     * Generate a random middle name from the default path.
     *
     * @return A random middle name.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public String generateDefaultMiddleName(int num) throws IOException {
        return generate(DefaultMiddleNamePath, num | 1);
    }

    /**
     * Generate a random last name from the default path.
     *
     * @return A random last name.
     * @throws IOException If an I/O error occurs.
     * @since v0.1.0
     */
    public String generateDefaultLastName() throws IOException {
        return generate(DefaultLastNamePath);
    }

    public String generateDefaultName(int num) throws IOException {
        return generateDefaultFirstName() + " " + generateDefaultLastName();
    }
}
