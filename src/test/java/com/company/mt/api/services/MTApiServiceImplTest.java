package com.company.mt.api.services;

import com.company.mt.api.constants.ErrorMessageConstants;
import com.company.mt.api.dto.TranslationDTO;
import com.company.mt.api.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MTApiServiceImplTest {

    MTApiService mtApiService;

    TranslationDTO translationDTO;

    @Mock
    ExternalMTApiService externalMTApiService;

    @BeforeEach
    void setUp() {
        mtApiService = new MTApiServiceImpl(externalMTApiService);
        translationDTO = new TranslationDTO();
        translationDTO.setSource_language("en-US");
        translationDTO.setTarget_language("de-DE");
        translationDTO.setDomain("academic");
        translationDTO.setContent("Test");
    }

    @Test
    @DisplayName("Validate translation - success scenario")
    void validateTranslation() {
        assertTrue(mtApiService.validateTranslation(translationDTO));
    }

    @Test
    @DisplayName("Validate translation - bad source language scenario")
    void validateTranslationSourceLanguageError() {
        translationDTO.setSource_language("test");
        BadRequestException exception = assertThrows(BadRequestException.class, () -> mtApiService.validateTranslation(translationDTO));
        assertTrue(exception.getMessage().contains(ErrorMessageConstants.SOURCE_LANGUAGE_BAD_REQUEST));
    }

    @Test
    @DisplayName("Validate translation - bad target language scenario")
    void validateTranslationTargetLanguageError() {
        translationDTO.setTarget_language("test");
        BadRequestException exception = assertThrows(BadRequestException.class, () -> mtApiService.validateTranslation(translationDTO));
        assertTrue(exception.getMessage().contains(ErrorMessageConstants.TARGET_LANGUAGE_BAD_REQUEST));
    }

    @Test
    @DisplayName("Validate translation - bad domain scenario")
    void validateTranslationDomainError() {
        translationDTO.setDomain("test");
        BadRequestException exception = assertThrows(BadRequestException.class, () -> mtApiService.validateTranslation(translationDTO));
        assertTrue(exception.getMessage().contains(ErrorMessageConstants.DOMAIN_BAD_REQUEST));
    }

    @Test
    @DisplayName("Validate translation - error in content word count scenario")
    void validateTranslationContentError() {
        translationDTO.setContent("word ".repeat(35));
        BadRequestException exception = assertThrows(BadRequestException.class, () -> mtApiService.validateTranslation(translationDTO));
        assertTrue(exception.getMessage().contains(ErrorMessageConstants.CONTENT_BAD_REQUEST));
    }

    @Test
    @DisplayName("Validate and do translation - success scenario")
    void validateAndDoTranslation() {
        String message = "This is some text!";
        when(externalMTApiService.translateContent(translationDTO)).thenReturn(message);
        assertTrue(mtApiService.validateAndDoTranslation(translationDTO).get("translated_content").equals(message));
    }
}