package com.truextend.reciipeapp.api.v1.mapper;

import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapperImpl implements RecipeMapper {
    @Override
    public RecipeDTO recipeToRecipeDTO(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setId(recipe.getId());
        recipeDTO.setDescription(recipe.getDescription());
        recipeDTO.setCookTime(recipe.getCookTime());
        recipeDTO.setPrepTime(recipe.getPrepTime());
        recipeDTO.setUser(recipe.getUser());

        return recipeDTO;
    }

    @Override
    public Recipe recipeDTOToRecipe(RecipeDTO recipeDTO) {
        if (recipeDTO == null) {
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setUser(recipeDTO.getUser());

        return recipe;
    }
}
