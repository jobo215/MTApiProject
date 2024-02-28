package com.company.mt.api.helpers;

import com.company.mt.api.entities.Domain;
import com.company.mt.api.entities.Language;
import com.company.mt.api.repositories.DomainRepository;
import com.company.mt.api.repositories.LanguageRepository;
import com.company.mt.api.utilities.StringUtility;

/**
 * @version 1.0
 * @since 1.0
 * Class which contains methods used in MTApiService class
 */
public class MTApiServiceHelper {

    private MTApiServiceHelper() {}

    /**
     * @param languageISO - Language iso string
     * Method gets language iso and its repository and checks if language iso exists
     * @return boolean
     */
    public static boolean isLanguageStringExisting(String languageISO) {
        Language language = LanguageRepository.getLanguageByLanguageISO(languageISO);
        return language != null;
    }

    /**
     * @param domainString - Domain string
     * Method gets domain and its repository and checks if domain exists
     * @return boolean
     */
    public static boolean isDomainStringExisting(String domainString) {
        Domain domain = DomainRepository.getDomainByDomainType(domainString);
        return domain != null;
    }

    /**
     * @param content - String content for translation
     * Method checks if content string contains more than 30 words
     * @return boolean
     */
    public static boolean hasMoreThan30WordsInContent(String content) {
        return StringUtility.wordCount(content) > 30;
    }

}
