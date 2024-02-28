package com.company.mt.api.utilities;

import java.util.StringTokenizer;

public class StringUtility {

    private StringUtility() {}

    public static int wordCount(String content) {
        if (content == null) {
            return 0;
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        return tokenizer.countTokens();
    }

    public static String removeWhitespaces(String content) {
        return content.replaceAll("\\s","");
    }

    public static String removeCurlyBraces(String content) {
        content = content.replaceAll("\\{", "");
        content = content.replaceAll("\\}", "");
        return content;
    }

    public static String removeDoubleQuotationMarks(String content) {
        return content.replaceAll("\"", "");
    }

}
