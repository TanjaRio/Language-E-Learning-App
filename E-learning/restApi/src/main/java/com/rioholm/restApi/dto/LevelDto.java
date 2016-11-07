package com.rioholm.restApi.dto;

import com.rioholm.language.entity.QuizEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@ApiModel("A level")
public class LevelDto {

    @ApiModelProperty("The name  of the category")
    public int level;

    @ApiModelProperty("The subcategories of the root category")
    public List<QuizEntity> questions;

    public LevelDto(){}

    public LevelDto(int level, List<QuizEntity> questions) {
        this.questions = questions;
        this.level = level;
    }


}
