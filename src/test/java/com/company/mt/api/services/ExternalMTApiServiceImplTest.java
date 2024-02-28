package com.company.mt.api.services;

import com.company.mt.api.dto.TranslationDTO;
import com.company.mt.api.repositories.DomainRepository;
import com.company.mt.api.repositories.LanguageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalMTApiServiceImplTest {

    ExternalMTApiService externalMTApiService;

    TranslationDTO translationDTO;

    @BeforeEach
    void setUp() {
        externalMTApiService = new ExternalMTApiServiceImpl();
        translationDTO = new TranslationDTO();
        translationDTO.setSource_language("en-US");
        translationDTO.setTarget_language("de-DE");
        translationDTO.setDomain("academic");
        translationDTO.setContent("Test");
    }

    @Test
    @DisplayName("Translate content - success scenario")
    void translateContent() {
        assertEquals("This is some mocked translation!", externalMTApiService.translateContent(translationDTO));
    }

    @Test
    @DisplayName("Get languages - success scenario")
    void getLanguages() {
        externalMTApiService.getLanguages();
        assertTrue(LanguageRepository.getLanguageByLanguageISO("es-ES").getLanguageISO().equals("es-ES"));
    }

    @Test
    @DisplayName("Get domains - success scenario")
    void getDomains() {
        externalMTApiService.getDomains();
        assertTrue(DomainRepository.getDomainByDomainType("formal").getDomainType().equals("formal"));
    }

}