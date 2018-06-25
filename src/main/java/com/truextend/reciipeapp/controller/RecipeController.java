package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.api.v1.dto.RecipeListDTO;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RecipeController.BASE_URL)
public class RecipeController {

    public static final String BASE_URL = "/api/v1/recipes";

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RecipeListDTO list() {
        return new RecipeListDTO(this.recipeService.list());
    }

    public Recipe saveRecipe(@Valid @RequestBody Recipe recipe) {
        return this.recipeService.save(recipe);
    }
}
