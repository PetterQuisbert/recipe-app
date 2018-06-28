package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> list();

    RecipeDTO getRecipeByDescription(String description);

    RecipeDTO getRecipeById(Long id);

    RecipeDTO save(RecipeDTO recipeDTO);
}
