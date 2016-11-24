package com.rioholm.language.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class LanguageEntity {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String language;

    @OneToMany
    private List<LevelEntity> languageLevels;

    public LanguageEntity() {}

    public LanguageEntity(String language) {
        this.setLanguage(language);
        this.setLanguageLevels(new ArrayList<>());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<LevelEntity> getLanguageLevels() {
        return languageLevels;
    }

    public void setLanguageLevels(List<LevelEntity> languageLevels) {
        this.languageLevels = languageLevels;
    }
}
