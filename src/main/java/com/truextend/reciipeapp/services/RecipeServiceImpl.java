package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> list() {
        return this.recipeRepository.findAll();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }
}
