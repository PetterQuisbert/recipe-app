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

public class RecipeServiceTest {

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

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeList);

        List<RecipeDTO> recipeDTOS = recipeService.list();

        assertEquals(2, recipeDTOS.size());
    }

    @Test
    public void save() {
    }
}