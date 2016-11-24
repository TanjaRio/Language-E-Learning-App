package com.rioholm.restApi.dto;

import com.rioholm.language.entity.LanguageEntity;
import com.rioholm.language.entity.LevelEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Bruker on 14.11.2016.
 */
public class LanguageConverter {
    public static LanguageDto transform(LanguageEntity entity){
        Objects.requireNonNull(entity);

        LanguageDto dto = new LanguageDto();
        dto.language = entity.getLanguage();
        dto.languageLevels = entity.getLanguageLevels();
        return dto;
    }

    public static List<LanguageDto> transform(List<LanguageEntity> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(LanguageConverter::transform)
                .collect(Collectors.toList());
    }
}
