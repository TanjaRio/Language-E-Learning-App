package com.rioholm.language.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

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

    @OneToOne

    private boolean isCompleted;
}
