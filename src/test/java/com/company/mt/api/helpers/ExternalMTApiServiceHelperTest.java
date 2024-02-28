package com.company.mt.api.helpers;

import com.company.mt.api.entities.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalMTApiServiceHelperTest {

    @Test
    @DisplayName("Get languages list from response test")
    void getLanguagesListFromResponse() {
        assertTrue(ExternalMTApiServiceHelper.getLanguagesListFromResponse("{\"en-US\", \"en-GB\", \"fr-FR\", \"de-DE\"}").get(0).getLanguageISO().equals("en-US"));
    }

    @Test
    @DisplayName("Get domains list from response test")
    void getDomainsListFromResponse() {
        assertTrue(ExternalMTApiServiceHelper.getDomainsListFromResponse("{\"academic\", \"business\", \"general\", \"causal\", \"creative\"}").get(0).getDomainType().equals("academic"));
    }

    @Test
    @DisplayName("Format content response string test")
    void formatContentResponseString() {
        assertTrue(ExternalMTApiServiceHelper.formatContentResponseString("{\"translation\":\"This is some mocked translation!\"}").equals("This is some mocked translation!"));
    }
}