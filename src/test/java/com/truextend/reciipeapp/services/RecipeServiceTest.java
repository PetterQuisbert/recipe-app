package com.truextend.reciipeapp.services;

import com.truextend.reciipeapp.api.v1.mapper.RecipeMapper;
import com.truextend.reciipeapp.api.v1.mapper.RecipeMapperImpl;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.repository.RecipeRepository;
import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {

    private static final Long ID = 1L;
    private static final String DESCRIPTION = "onions";

    private RecipeMapper recipeMapper;

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeMapper = new RecipeMapperImpl();

        recipeService = new RecipeServiceImpl(recipeRepository, recipeMapper);
    }

    @Test
    public void list() {

        List<Recipe> recipeList = Arrays.asList(new Recipe(), new Recipe());

        when(recipeRepository.findAll()).thenReturn(recipeList);

        List<RecipeDTO> recipeDTOS = recipeService.list();

        assertEquals(2, recipeDTOS.size());
    }

    @Test
    public void save() {

    }

    @Test
    public void getRecipeByDescription() {
        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setDescription(DESCRIPTION);

        when(recipeRepository.findByDescription(anyString())).thenReturn(recipe);

        RecipeDTO recipeDTO = recipeService.getRecipeByDescription("hi");


        assertEquals(ID, recipeDTO.getId());
        assertEquals(DESCRIPTION, recipeDTO.getDescription());

    }
}