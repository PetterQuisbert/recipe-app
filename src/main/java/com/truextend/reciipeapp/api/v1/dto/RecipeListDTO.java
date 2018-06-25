package com.truextend.reciipeapp.api.v1.dto;

import java.util.List;

public class RecipeListDTO {

    List<RecipeDTO> recipeDTOS;

    public RecipeListDTO() {
    }

    public RecipeListDTO(List<RecipeDTO> recipeDTOS) {
        this.recipeDTOS = recipeDTOS;
    }

    public List<RecipeDTO> getRecipeDTOS() {
        return recipeDTOS;
    }

    public void setRecipeDTOS(List<RecipeDTO> recipeDTOS) {
        this.recipeDTOS = recipeDTOS;
    }
}
