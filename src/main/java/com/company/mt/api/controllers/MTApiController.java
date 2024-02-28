package com.company.mt.api.controllers;

import com.company.mt.api.dto.TranslationDTO;
import com.company.mt.api.services.MTApiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version 1.0
 * @since 1.0
 * Rest controller class which handles adapter API endpoints
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MTApiController {

    private final MTApiService mtApiService;

    /**
     * @param translationDTO - TranslationDTO object which contains source language, target language,
     *                          domain and content
     * The method retrieves a TranslationDTO object from the client side and forwards it to the business logic layer.
     * @return ResponseEntity<Map<String, String>> - ResponseEntity object with a map holding translated content.
     */
    @PostMapping("/validated-translation")
    public ResponseEntity<Map<String, String>> validateAndDoTranslation(@Valid @RequestBody TranslationDTO translationDTO) {
        return ResponseEntity.ok(mtApiService.validateAndDoTranslation(translationDTO));
    }

}
