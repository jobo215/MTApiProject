package com.company.mt.api.repositories;

import com.company.mt.api.entities.Domain;

import java.util.ArrayList;
import java.util.List;

public class DomainRepository {

    private static  DomainRepository instance;

    private List<Domain> domains;

    private DomainRepository() {
        domains = new ArrayList<>();
        domains.add(new Domain("academic"));
        domains.add(new Domain("business"));
        domains.add(new Domain("general"));
        domains.add(new Domain("casual"));
        domains.add(new Domain("creative"));
    }

    public static DomainRepository getInstance() {
        if (instance == null) {
            instance = new DomainRepository();
        }
        return instance;
    }

    public static Domain getDomainByDomainType(String domainType) {
        for (Domain domain : getInstance().domains) {
            if (domain.getDomainType().equals(domainType)) {
                return domain;
            }
        }
        return null;
    }

    public static void save(List<Domain> domains) {
        getInstance().domains = domains;
    }

}
