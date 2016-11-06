package com.rioholm.restApi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import no.westerdals.quiz.entity.SubCategory;

import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@ApiModel("A level")
public class LevelDto {

    @ApiModelProperty("The name  of the category")
    public String categoryName;

    @ApiModelProperty("The subcategories of the root category")
    public List<SubCategory> subCategoryList;

    public LevelDto(){}

    public LevelDto(String categoryName, List<SubCategory> subCategoryList) {
        this.categoryName = categoryName;
        this.subCategoryList = subCategoryList;
    }


}
