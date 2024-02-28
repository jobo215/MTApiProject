package com.company.mt.api.services;

import com.company.mt.api.dto.TranslationDTO;

public interface ExternalMTApiService {

    String translateContent(TranslationDTO translationDTO);

    void getLanguages();

    void getDomains();

}
