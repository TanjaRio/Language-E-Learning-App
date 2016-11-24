package com.rioholm.language.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Entity
public class LevelEntity {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private int level;

    @ManyToOne
    private LanguageEntity language;

    @OneToMany
    private List<QuizEntity> questions;

    private boolean isCompleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<QuizEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizEntity> questions) {
        this.questions = questions;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
