package com.truextend.reciipeapp.api.v1.mapper;

import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;

public interface RecipeMapper {
    RecipeDTO recipeToRecipeDTO(Recipe recipe);
    Recipe recipeDTOToRecipe(RecipeDTO recipeDTO);
}
