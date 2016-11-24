package com.rioholm.language.ejb;

import com.rioholm.language.entity.LanguageEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Stateless
public class LanguageEJB {
    @PersistenceContext
    private EntityManager em;

    public Long createLanguage(String language) {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setLanguage(language);
    }
}
