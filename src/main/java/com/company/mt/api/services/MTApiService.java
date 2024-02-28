package com.company.mt.api.services;

import com.company.mt.api.dto.TranslationDTO;

import java.util.Map;

public interface MTApiService {

    boolean validateTranslation(TranslationDTO translationDTO);

    Map<String, String> validateAndDoTranslation(TranslationDTO translationDTO);

}
