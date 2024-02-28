package com.company.mt.api.helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MTApiServiceHelperTest {

    @Test
    @DisplayName("Is language string existing - true scenario")
    void isLanguageStringExisting() {
        assertTrue(MTApiServiceHelper.isLanguageStringExisting("en-US"));
    }

    @Test
    @DisplayName("Is language string existing - false scenario")
    void isLanguageStringExistingFalseScenario() {
        assertFalse(MTApiServiceHelper.isLanguageStringExisting("en-EN"));
    }

    @Test
    @DisplayName("Is domain string existing - true scenario")
    void isDomainStringExisting() {
        assertTrue(MTApiServiceHelper.isDomainStringExisting("academic"));
    }

    @Test
    @DisplayName("Is domain string existing - false scenario")
    void isDomainStringExistingFalseScenario() {
        assertFalse(MTApiServiceHelper.isDomainStringExisting("test"));
    }

    @Test
    @DisplayName("Has more than 30 words in content - true scenario")
    void hasMoreThan30WordsInContent() {
        assertTrue(MTApiServiceHelper.hasMoreThan30WordsInContent("test ".repeat(32)));
    }

    @Test
    @DisplayName("Has more than 30 words in content - false scenario")
    void hasMoreThan30WordsInContentFalseScenario() {
        assertFalse(MTApiServiceHelper.hasMoreThan30WordsInContent("test test"));
    }
}