package com.company.mt.api.services;

import com.company.mt.api.dto.TranslationDTO;
import com.company.mt.api.entities.Domain;
import com.company.mt.api.entities.Language;
import com.company.mt.api.helpers.ExternalMTApiServiceHelper;
import com.company.mt.api.repositories.DomainRepository;
import com.company.mt.api.repositories.LanguageRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 * A class containing methods that interact with an external API.
 */
@Service
public class ExternalMTApiServiceImpl implements ExternalMTApiService {


    /**
     * @param translationDTO - TranslationDTO object which contains source language, target language,
     *                         domain and content
     * This method invokes another method acting as a mocked API, retrieving translated content from the response.
     * @return String with translated text
     */
    @Override
    public String translateContent(TranslationDTO translationDTO) {
        String translation = callExternalApiMock("/translate");
        return ExternalMTApiServiceHelper.formatContentResponseString(translation);
    }

    /**
     *  This method invokes another method acting as a mocked API,
     *              retrieving languages ISO from the response.
     *              Method is called once every day with scheduled job.
     */
    @Override
    @Async
    @Scheduled(cron = "1 0 0 * * *", zone = "Europe/Belgrade")
    public void getLanguages() {
        String languagesResponse = callExternalApiMock("/languages");
        List<Language> languages = ExternalMTApiServiceHelper.getLanguagesListFromResponse(languagesResponse);
        LanguageRepository.save(languages);
    }

    /**
     *  This method invokes another method acting as a mocked API,
     *              retrieving domains from the response.
     *              Method is called once every day with scheduled job.
     */
    @Override
    @Async
    @Scheduled(cron = "1 0 0 * * *", zone = "Europe/Belgrade")
    public void getDomains() {
        String domainsResponse = callExternalApiMock("/domains");
        List<Domain> domains = ExternalMTApiServiceHelper.getDomainsListFromResponse(domainsResponse);
        DomainRepository.save(domains);
    }

    private String callExternalApiMock(String endpoint) {
        if (endpoint.equals("/translate")) {
            return "{\"translation\":\"This is some mocked translation!\"}";
        }
        if (endpoint.equals("/languages")) {
            return "{\"en-US\", \"en-GB\", \"fr-FR\", \"de-DE\", \"es-ES\"}";
        }
        if (endpoint.equals("/domains")) {
            return "{\"academic\", \"business\", \"general\", \"causal\", \"creative\", \"formal\"}";
        }
        return null;
    }

}
