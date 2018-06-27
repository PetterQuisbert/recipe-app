package com.truextend.reciipeapp.bootstrap;

import com.truextend.reciipeapp.api.v1.dto.RecipeDTO;
import com.truextend.reciipeapp.config.SecurityUtility;
import com.truextend.reciipeapp.domain.Role;
import com.truextend.reciipeapp.domain.User;
import com.truextend.reciipeapp.domain.UserRole;
import com.truextend.reciipeapp.services.RecipeService;
import com.truextend.reciipeapp.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserService userService;
    private final RecipeService recipeService;

    public Bootstrap(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        populateUserData();
        populateRecipeData();
    }

    public void populateRecipeData() {
        User userPetter = userService.findById(1L);
        User userAdmin = userService.findById(2L);

        RecipeDTO recipe1 = new RecipeDTO();
        recipe1.setId(1L);
        recipe1.setDescription("onions1");
        recipe1.setCookTime(10);
        recipe1.setPrepTime(12);
        recipe1.setUser(userAdmin);

        recipeService.save(recipe1);

        RecipeDTO recipe2 = new RecipeDTO();
        recipe2.setId(2L);
        recipe2.setDescription("onions 2");
        recipe2.setCookTime(11);
        recipe2.setPrepTime(2);
        recipe2.setUser(userPetter);

        recipeService.save(recipe2);

        RecipeDTO recipe3 = new RecipeDTO();
        recipe3.setId(3L);
        recipe3.setDescription("onions 3");
        recipe3.setCookTime(1);
        recipe3.setPrepTime(23);
        recipe3.setUser(userPetter);

        recipeService.save(recipe3);
    }

    private void populateUserData() {
        User user1 = new User();
        user1.setFirstname("Petter");
        user1.setLastname("Quisbert");
        user1.setEmail("petter.quisbert@gmail.com");
        user1.setUsername("petter");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("ROLE_USER");

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
        userRoles.clear();

        User user2 = new User();
        user2.setFirstname("Admin");
        user2.setLastname("Admin");
        user2.setEmail("admin@gmail.com");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName("ROLE_ADMIN");

        userRoles.add(new UserRole(user2, role2));

        userService.createUser(user2, userRoles);
        userRoles.clear();
    }
}
