package com.truextend.reciipeapp.repository;

import com.truextend.reciipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByDescription(String description);
}
