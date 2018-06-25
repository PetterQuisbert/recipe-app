package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> list();
    Recipe save(Recipe recipe);
}
