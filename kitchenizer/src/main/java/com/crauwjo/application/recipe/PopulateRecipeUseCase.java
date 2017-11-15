package com.crauwjo.application.recipe;


import com.crauwjo.application_api.recipe.PopulateRecipeInterface;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crauwjo.persistence.RecipeRepository;
import com.crauwjo.domain.recipe.Recipe;


import java.util.List;

@NoArgsConstructor
@Transactional
public class PopulateRecipeUseCase implements PopulateRecipeInterface {



    public void populate(Recipe recipe){

    }

    public void populate(List<Recipe> recipes){


    }

}
