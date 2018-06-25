package com.truextend.reciipeapp.mapper;

import com.truextend.reciipeapp.api.v1.mapper.RecipeMapper;
import com.truextend.reciipeapp.api.v1.mapper.RecipeMapperImpl;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeMapperTest {

    private RecipeMapper recipeMapper;

    @Before
    public void setUp() throws Exception {
        recipeMapper = new RecipeMapperImpl();
    }

    @Test
    public void recipeToRecipeDTO() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setDescription("onions");

        RecipeDTO recipeDTO = this.recipeMapper.recipeToRecipeDTO(recipe);

        assertEquals(Long.valueOf(1L), recipeDTO.getId());
        assertEquals("onions", recipeDTO.getDescription());
    }

    @Test
    public void recipeDTOToRecipe() {

        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(2L);
        recipeDTO.setDescription("onionsDTO");

        Recipe recipe = this.recipeMapper.recipeDTOToRecipe(recipeDTO);

        assertEquals(Long.valueOf(2L), recipe.getId());
        assertEquals("onionsDTO", recipe.getDescription());
    }
}