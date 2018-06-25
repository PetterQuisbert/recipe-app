package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.api.v1.dto.RecipeListDTO;
import com.truextend.reciipeapp.api.v1.mapper.RecipeMapper;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.services.RecipeService;
import com.truextend.reciipeapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RecipeController.BASE_URL)
public class RecipeController {

    public static final String BASE_URL = "/api/v1/recipes";

    private final RecipeMapper recipeMapper;
    private final RecipeService recipeService;
    private final UserService userService;

    public RecipeController(RecipeMapper recipeMapper, RecipeService recipeService, UserService userService) {
        this.recipeMapper = recipeMapper;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RecipeListDTO list() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            User currentUser = userService.findByUsername(currentUserName);
            List<Recipe> recipeList = currentUser.getRecipeList();

            List<RecipeDTO> recipeDTOList = recipeList
                    .stream()
                    .map(recipeMapper::recipeToRecipeDTO)
                    .collect(Collectors.toList());

            return new RecipeListDTO(recipeDTOList);

        }
        return new RecipeListDTO(Arrays.asList());
    }

    public Recipe saveRecipe(@Valid @RequestBody Recipe recipe) {
        return this.recipeService.save(recipe);
    }
}
