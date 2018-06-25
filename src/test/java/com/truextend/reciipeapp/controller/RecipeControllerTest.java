package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Authentication authentication;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    public void list() throws Exception {
//        RecipeDTO recipe1 = new RecipeDTO();
//        recipe1.setId(1L);
//        recipe1.setDescription("onions");
//
//        RecipeDTO recipe2 = new RecipeDTO();
//        recipe2.setId(2L);
//        recipe2.setDescription("onions 2");
//
//        List<RecipeDTO> recipeDTOS = Arrays.asList(recipe1, recipe2);
//
//        when(recipeService.list()).thenReturn(recipeDTOS);
//
//        mockMvc.perform(get(RecipeController.BASE_URL)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.recipeDTOS", hasSize(2)));

    }

}