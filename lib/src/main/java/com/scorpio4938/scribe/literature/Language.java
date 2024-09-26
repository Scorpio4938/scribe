package com.scorpio4938.scribe.literature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Language {
    private final String code;

    private static final Map<String, List<String>> LANGUAGE_FAMILIES = new HashMap<>();

    public Language(String code) {
        this.code = code;
        this.init();
    }

    private void init() {
        LANGUAGE_FAMILIES.put("Indo-European", List.of("en_us", "en_uk", "es", "fr", "de", "it"));
        LANGUAGE_FAMILIES.put("Sino-Tibetan", List.of("zh", "my"));
        LANGUAGE_FAMILIES.put("Afro-Asiatic", List.of("ar", "he"));
        // Add more language families as needed
    }

    public List<String> getFamily() {
        for (List<String> languages : LANGUAGE_FAMILIES.values()) {
            if (languages.contains(code)) {
                return languages;
            }
        }
        return null;
    }

    public List<String> translate(List<String> list) {
        List<String> translated = new ArrayList<>();

        return translated;
    }

    ;

    public String getCode() {
        return code;
    }

    public String getLang() {
        return code.split("_")[0];
    }

    public String getRegion() {
        return code.split("_")[1];
    }

    public Map<String, List<String>> getLanguageFamilies() {
        return LANGUAGE_FAMILIES;
    }
}
