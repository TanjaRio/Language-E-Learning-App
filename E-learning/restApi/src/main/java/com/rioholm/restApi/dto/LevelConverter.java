package com.rioholm.restApi.dto;

import com.rioholm.language.entity.LevelEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class LevelConverter {
    public static LevelDto transform(LevelEntity entity){
        Objects.requireNonNull(entity);

        LevelDto dto = new LevelDto();
        dto.level = entity.getLevel();
        dto.questions = entity.getQuestions();
        return dto;
    }

    public static List<LevelDto> transform(List<LevelEntity> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(LevelConverter::transform)
                .collect(Collectors.toList());
    }
}
