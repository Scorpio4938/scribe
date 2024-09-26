package com.scorpio4938.scribe.service.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScribeStringProcessor {

    /**
     * Join the List into string using blank as separation.
     *
     * @param list The list.
     * @return A blank-separated string.
     * @since v0.1.0
     */
    public static String joinList(List<String> list) {
        return String.join(" ", list);
    }

    /**
     * Join two string using hyphen.
     *
     * @return A hyphen-separated string.
     * @since v0.1.0
     */
    public static String hyphenate(String a, String b) {
        return String.join("-", a, b);
    }

    /**
     * Join the list using hyphen.
     *
     * @return A hyphen-separated string list.
     * @since v0.1.0
     */
    public static List<String> hyphenate(List<String> list) {
        return List.of(String.join("-", list));
    }

    /**
     * Join two list of string using hyphen.
     *
     * @return A hyphen-separated string list.
     * @since v0.1.0
     */
    public static List<String> hyphenate(List<String> a, List<String> b) {
        return List.of(Stream.concat(a.stream(), b.stream())
                .collect(Collectors.joining("-")));
    }
}
