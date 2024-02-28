package com.company.mt.api.helpers;

import com.company.mt.api.entities.Domain;
import com.company.mt.api.entities.Language;
import com.company.mt.api.utilities.StringUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @since 1.0
 * Class which contains methods used in ExternalMTApiService class
 */
public class ExternalMTApiServiceHelper {

    private ExternalMTApiServiceHelper() {}

    /**
     * @param languagesResponse - String with languages response (in JSON representation)
     * Method gets languages response string and makes list from it
     * @return List<Languages> - List of languages retrieved from response
     */
    public static List<Language> getLanguagesListFromResponse(String languagesResponse) {
        languagesResponse = prepareResponseString(languagesResponse);
        List<Language> languages = new ArrayList<>();
        for (String languageISO : languagesResponse.split(",")) {
            languages.add(new Language(languageISO));
        }
        return languages;
    }

    /**
     * @param domainsResponse - String with domains response (in JSON representation)
     * Method gets domains response string and makes list from it
     * @return List<Domain> - List of domains retrieved from response
     */
    public static List<Domain> getDomainsListFromResponse(String domainsResponse) {
        domainsResponse = prepareResponseString(domainsResponse);
        List<Domain> domains = new ArrayList<>();
        for (String domainName : domainsResponse.split(",")) {
            domains.add(new Domain(domainName));
        }
        return domains;
    }

    public static String formatContentResponseString(String responseString) {
        return responseString.split(":")[1].split("\"")[1];
    }

    private static String prepareResponseString(String response) {
        response = StringUtility.removeWhitespaces(response);
        response = StringUtility.removeCurlyBraces(response);
        response = StringUtility.removeDoubleQuotationMarks(response);
        return response;
    }

}
