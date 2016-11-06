package com.rioholm.restApi.dto;

import no.westerdals.quiz.entity.RootCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class LevelConverter {
    public static LevelDto transform(RootCategory entity){
        Objects.requireNonNull(entity);

        LevelDto dto = new LevelDto();
        dto.categoryName = entity.getCategoryName();
        dto.subCategoryList = entity.getSubCategoryList();
        return dto;
    }

    public static List<LevelDto> transform(List<LevelDto> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(LevelDto::transform)
                .collect(Collectors.toList());
    }
}
