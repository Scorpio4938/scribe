package com.scorpio4938.scribe.service.utils;

import java.io.IOException;
import java.util.List;

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
}
