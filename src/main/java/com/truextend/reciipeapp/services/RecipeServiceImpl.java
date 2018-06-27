package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.api.v1.mapper.RecipeMapper;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeMapper recipeMapper;

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDTO> list() {
        return this.recipeRepository.findAll()
                .stream()
                .map(recipeMapper::recipeToRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO getRecipeByDescription(String description) {
        Recipe byDescription = recipeRepository.findByDescription(description);

        return recipeMapper.recipeToRecipeDTO(byDescription);
    }

    @Override
    public RecipeDTO save(RecipeDTO recipeDTO) {
        Recipe recipe = recipeMapper.recipeDTOToRecipe(recipeDTO);
        return recipeMapper.recipeToRecipeDTO(this.recipeRepository.save(recipe));
    }
}
