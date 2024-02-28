package com.company.mt.api.repositories;

import com.company.mt.api.entities.Language;
import java.util.ArrayList;
import java.util.List;

public class LanguageRepository {

    private static LanguageRepository instance;
    private List<Language> languages;

    private LanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language("en-US"));
        languages.add(new Language("en-GB"));
        languages.add(new Language("fr-FR"));
        languages.add(new Language("de-DE"));
    }

    public static LanguageRepository getInstance() {
        if (instance == null) {
            instance = new LanguageRepository();
        }
        return instance;
    }

    public static Language getLanguageByLanguageISO(String languageISO) {
        for (Language language : getInstance().languages) {
            if (language.getLanguageISO().equals(languageISO)) {
                return language;
            }
        }
        return null;
    }

    public static void save(List<Language> languages) {
        getInstance().languages = languages;
    }

}
