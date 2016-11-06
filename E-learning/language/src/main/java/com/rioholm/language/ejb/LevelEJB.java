package com.rioholm.language.ejb;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class LevelEJB {
    @Id @GeneratedValue
    private long levelId;
    private int level;

}
