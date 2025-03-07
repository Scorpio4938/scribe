package com.scorpio4938.scribe.literature.names;

import com.scorpio4938.scribe.literature.Language;
import com.scorpio4938.scribe.literature.LitGenerator;
import com.scorpio4938.scribe.service.reader.ScribeFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScribeDefaultEnglishNameGenerator implements LitGenerator {
    private final String ResourceNamePath = "src/main/resources/names/";
    private final String DefaultLangCode = "en_uk";
    private final String DefaultGender = "male"; // This is for the simplicity of code.

//    private final String DefaultUKEngFirstNamePath = "src/main/resources/names/en/uk_male_first_names.txt";
//    private final String DefaultUKEngMiddleNamePath = "src/main/resources/names/en/uk_male_middle_names.txt";
//    private final String DefaultUKEngLastNamePath = "src/main/resources/names/en/uk_male_last_names.txt";

    private String FirstNamePath;
    private String MiddleNamePath;
    private String LastNamePath;

    private String langCode = this.DefaultLangCode;
    private String gender = this.DefaultGender;
    private Language lang;

    public ScribeDefaultEnglishNameGenerator() {
        // Temp settings for now, waiting for further language settings
//        this.FirstNamePath = this.DefaultUKEngFirstNamePath;
//        this.MiddleNamePath = this.DefaultUKEngMiddleNamePath;
//        this.LastNamePath = this.DefaultUKEngLastNamePath;

//        this.langCode = this.DefaultlangCode;
        init();
    }

    public ScribeDefaultEnglishNameGenerator(String langCode, String gender) {
        // Temp settings for now, waiting for further language settings
//        this.FirstNamePath = this.DefaultUKEngFirstNamePath;
//        this.MiddleNamePath = this.DefaultUKEngMiddleNamePath;
//        this.LastNamePath = this.DefaultUKEngLastNamePath;

        this.langCode = langCode;
        this.gender = gender;
        init();
    }

    @Override
    public void init() {
        this.lang = new Language(this.langCode);
        this.FirstNamePath = this.setPath(this.gender, "first_names");
        this.MiddleNamePath = this.setPath(this.gender, "middle_names");
        this.LastNamePath = this.setPath(this.gender, "last_names");
    }

    /**
     * Set the path from the gender, name-place, and lang.
     *
     * @param gender    The gender of the path.
     * @param nameplace The name-place of the path (first, middle, last).
     * @return A path.
     * @since 0.1.0
     */
    public String setPath(String gender, String nameplace) {
        return ResourceNamePath + lang.getLang() + "/" + lang.getRegion() + "_" + gender + "_" + nameplace + ".txt";
    }

    /**
     * Generate a random single name from the path given.
     *
     * @param filePath The path to the file.
     * @return A random single name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    @Override
    public List<String> generate(String filePath) throws IOException {
        ScribeFileReader reader = new ScribeFileReader();
        Random random = new Random();
        List<String> nameList = reader.txtStringArrayListReader(filePath);
        return List.of(nameList.get(random.nextInt(nameList.size())));
    }

    /**
     * Generate a number of random single name from the path given.
     *
     * @param filePath The path to the file.
     * @param num      The number of name needed.
     * @return A list of random single names.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    @Override
    public List<String> generate(String filePath, int num) throws IOException {
        List<String> names = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < num; i++) {
            List<String> generated = this.generate(filePath);
            if (!generated.equals(List.of(temp))) {
                names.add(generated.get(0));
                temp = generated.get(0);
            } else {
                i -= 1;
            }
        }
        return names;
    }

    /**
     * Generate a random first name from the default path.
     *
     * @return A random first name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultFirstName() throws IOException {
        return this.generate(this.FirstNamePath);
    }

    /**
     * Generate a given number of random middle name from the default path.
     *
     * @param num The number of middle names.
     * @return A random middle name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultMiddleName(int num) throws IOException {
        return this.generate(this.MiddleNamePath, num);
    }

    /**
     * Generate a random middle name from the default path.
     *
     * @return A random middle name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultMiddleName() throws IOException {
        return this.generate(this.MiddleNamePath, 1);
    }

    /**
     * Generate a random last name from the default path.
     *
     * @return A random last name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultLastName() throws IOException {
        return this.generate(this.LastNamePath);
    }

    /**
     * Generate a full name with a number of middle name.
     *
     * @return A full name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultName() throws IOException {
        return this.generateDefaultName(1);
    }

    /**
     * Generate a full name with a number of middle name.
     *
     * @param num The number of middle names.
     * @return A full name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultName(int num) throws IOException {
        List<String> names = new ArrayList<>();
        names.addAll(this.generateDefaultFirstName());
        names.addAll(this.generateDefaultMiddleName(num));
        names.addAll(this.generateDefaultLastName());
        return names;
    }

    /**
     * Generate a full name with a number of middle name.
     *
     * @param title The title of the name.
     * @return A full name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultName(String title) throws IOException {
        return this.generateDefaultName(title, 1);
    }

    /**
     * Generate a full name with a number of middle name.
     *
     * @param title The title of the name.
     * @param num   The number of middle names.
     * @return A full name.
     * @throws IOException If an I/O error occurs.
     * @since 0.1.0
     */
    public List<String> generateDefaultName(String title, int num) throws IOException {
        List<String> names = new ArrayList<>();
        names.add(title);
        names.addAll(this.generateDefaultName(num));
        return names;
    }

    //utils
    @Override
    public String getLangCode() {
        return this.langCode;
    }

    @Override
    public Language getLang() {
        return this.lang;
    }

    public String getGender() {
        return this.gender;
    }
}
