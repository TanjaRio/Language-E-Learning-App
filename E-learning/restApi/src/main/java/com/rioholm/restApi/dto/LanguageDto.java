package com.rioholm.restApi.dto;

import com.rioholm.language.entity.LevelEntity;
import com.rioholm.language.entity.QuizEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Bruker on 14.11.2016.
 */
@ApiModel("A language")
public class LanguageDto {
    @ApiModelProperty("The id of the language")
    public Long id;

    @ApiModelProperty("The name  of the language")
    public String language;

    @ApiModelProperty("The levels of the language")
    public List<LevelEntity> languageLevels;

    public LanguageDto(){}

    public LanguageDto(String language, List<LevelEntity> languageLevels) {
        this.language = language;
        this.languageLevels = languageLevels;
    }
}
