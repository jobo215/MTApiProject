package com.company.mt.api.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilityTest {

    @Test
    @DisplayName("Word count - success scenario")
    void wordCount() {
        assertEquals(3, StringUtility.wordCount("This is test"));
    }

    @Test
    @DisplayName("Word count - null scenario")
    void wordCountNullValue() {
        assertEquals(0, StringUtility.wordCount(null));
    }

    @Test
    @DisplayName("Remove whitespaces - success scenario")
    void removeWhitespaces() {
        assertEquals("Thisistest", StringUtility.removeWhitespaces("This is test"));
    }

    @Test
    @DisplayName("Remove curly braces - success scenario")
    void removeCurlyBraces() {
        assertEquals("This is test", StringUtility.removeCurlyBraces("{This is test}"));
    }

    @Test
    @DisplayName("Remove double quotation marks - success scenario")
    void removeDoubleQuotationMarks() {
        assertEquals("This is test", StringUtility.removeDoubleQuotationMarks("\"This is test\""));
    }
}