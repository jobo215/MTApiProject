package com.company.mt.api.services;

import com.company.mt.api.constants.ErrorMessageConstants;
import com.company.mt.api.dto.TranslationDTO;
import com.company.mt.api.exceptions.BadRequestException;
import com.company.mt.api.exceptions.NotFoundException;
import com.company.mt.api.helpers.MTApiServiceHelper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version 1.0
 * @since 1.0
 */
@Service
public class MTApiServiceImpl implements MTApiService {


    private final ExternalMTApiService externalMTApiService;

    public MTApiServiceImpl(ExternalMTApiService externalMTApiService) {
        this.externalMTApiService = externalMTApiService;
    }

    /**
     * @param translationDTO - TranslationDTO object which contains source language, target language,
     *                          domain and content
     * The method validates whether the source language, target language, and domain exist,
     *              and if the content has fewer than 30 words.
     *              It throws an error if some of the fields are not valid.
     * @return boolean
     */
    @Override
    public boolean validateTranslation(TranslationDTO translationDTO) {
        if (!MTApiServiceHelper.isLanguageStringExisting(translationDTO.getSource_language())) {
            throw new BadRequestException(ErrorMessageConstants.SOURCE_LANGUAGE_BAD_REQUEST);
        }
        if (!MTApiServiceHelper.isLanguageStringExisting(translationDTO.getTarget_language())) {
            throw new BadRequestException(ErrorMessageConstants.TARGET_LANGUAGE_BAD_REQUEST);
        }
        if (!MTApiServiceHelper.isDomainStringExisting(translationDTO.getDomain())) {
            throw new BadRequestException(ErrorMessageConstants.DOMAIN_BAD_REQUEST);
        }
        if (MTApiServiceHelper.hasMoreThan30WordsInContent(translationDTO.getContent())) {
            throw new BadRequestException(ErrorMessageConstants.CONTENT_BAD_REQUEST);
        }
        return true;
    }

    /**
     * @param translationDTO - TranslationDTO object which contains source language, target language,
     *                         domain and content
     * Method does validation and gets translated content value from external API
     * @return Map<String, String> - map with translated content value
     */
    @Override
    public Map<String, String> validateAndDoTranslation(TranslationDTO translationDTO) {
        if (validateTranslation(translationDTO)) {
            return Map.of("translated_content", externalMTApiService.translateContent(translationDTO));
        }
        throw new NotFoundException(ErrorMessageConstants.TRANSLATION_NOT_FOUND);
    }

}
