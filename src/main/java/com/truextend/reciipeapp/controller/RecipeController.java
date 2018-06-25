package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"", "/"})
    public List<Recipe> list() {
        return this.recipeService.list();
    }

    public Recipe saveRecipe(@Valid @RequestBody Recipe recipe) {
        return this.recipeService.save(recipe);
    }
}
