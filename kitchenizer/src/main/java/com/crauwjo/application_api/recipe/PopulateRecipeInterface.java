package com.crauwjo.application_api.recipe;

import com.crauwjo.domain.recipe.Recipe;

import java.util.List;

public interface PopulateRecipeInterface {
    void populate(Recipe recipe);
    void populate(List<Recipe> recipes);
}
