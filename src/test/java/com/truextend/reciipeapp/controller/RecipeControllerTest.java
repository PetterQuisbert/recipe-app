package com.truextend.reciipeapp.controller;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.domain.Recipe;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.services.RecipeService;
import com.truextend.reciipeapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RecipeControllerTest {
    private static final Long ID = 1L;
    private static final String DESCRIPTION = "onions";


    @Mock
    RecipeService recipeService;

    @Mock
    User userTmp;

    @Mock
    Authentication authentication;

    @Mock
    SecurityContext securityContext;

    @Mock
    UserService userService;

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
//        userTmp = new User();
//        userTmp.setId(1L);
//        userTmp.setUsername("petter");
//
//        Recipe recipe1 = new Recipe();
//        recipe1.setId(1L);
//        recipe1.setDescription("onions1");
//        recipe1.setUser(userTmp);
//
//        Recipe recipe2 = new Recipe();
//        recipe2.setId(2L);
//        recipe2.setDescription("onions2");
//        recipe2.setUser(userTmp);
//
//        List<Recipe> recipeList = Arrays.asList(recipe1, recipe2);
//
//        when(userService.findByUsername(anyString())).thenReturn(userTmp);
//
//        when(userTmp.getRecipeList()).thenReturn(recipeList);
//
//        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
//        SecurityContextHolder.setContext(securityContext);
//
//        mockMvc.perform(get("/api/v1/recipes")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.recipeList", hasSize(2)));

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

//    @Test
//    public void getRecipeByDescription() throws Exception {
//        RecipeDTO recipeDTO = new RecipeDTO();
//        recipeDTO.setId(ID);
//        recipeDTO.setDescription(DESCRIPTION);
//
//        when(recipeService.getRecipeByDescription(anyString())).thenReturn(recipeDTO);
//
//        mockMvc.perform(get(RecipeController.BASE_URL + "/onions")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.description", equalTo(DESCRIPTION)));
//
//    }

    @Test
    public void saveRecipe() {
    }

    @Test
    public void getRecipeById() throws Exception {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(ID);
        recipeDTO.setDescription(DESCRIPTION);
        recipeDTO.setRecipeUrl("/api/recipes/1");

        when(recipeService.getRecipeById(anyLong())).thenReturn(recipeDTO);

        mockMvc.perform(get("/api/v1/recipes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo(DESCRIPTION)));

    }
}