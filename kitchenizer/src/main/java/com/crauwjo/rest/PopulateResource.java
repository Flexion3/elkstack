package com.crauwjo.rest;

import com.crauwjo.domain.RecipeJsonResponse;
import com.crauwjo.application.recipe.PopulateRecipeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crauwjo.domain.recipe.Recipe;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static javax.swing.UIManager.get;

@RestController
public class PopulateResource {

    private static final String BASE_URL = "https://spoonacular-com.crauwjo.domain.recipe-food-nutrition-v1.p.mashape.com";
//
//    @Autowired
//    private PopulateRecipeUseCase populateRecipeUseCase;

    private Invocation.Builder spoonacularClient(String query){

        return ClientBuilder.newClient()
                .target(BASE_URL + query)
                .property("Accept", "com/crauwjo/application/json")
                .property("Request", "com/crauwjo/application/json")
                .request()
                .header("X-Mashape-Key", "BnEOyAmq9Rmshg7xuTgTwoxg7u0Np15S0XXjsnxUTiwnlJMBCE");

    }

    @GetMapping("/recipes")
    public List<Recipe> addRecipes(){


        String query = "/recipes/search?number=20&offset=0&query=burger";

        List<Recipe> recipes = spoonacularClient(query).get(RecipeJsonResponse.class).getResults();


        return recipes;
    }

    @GetMapping("/ingredients")
    public Object addIngredients(){
        List<Recipe> foundrecipes = addRecipes();

        List<Recipe> fullRecipes = foundrecipes.stream()
                .map(recipe -> spoonacularClient("/recipes/"+recipe.getId()+"/information").get(Recipe.class))
                .collect(toList());

        //populateRecipeUseCase.populate(fullRecipes);
        return fullRecipes;


//        return spoonacularClient("/recipes/"+foundrecipes.get(0).getId()+"/information").get(Recipe.class);



        //final List<Object> recipesWithIngredients = new ArrayList();
//        foundrecipes.stream().forEach(com.crauwjo.domain.recipe -> {
//            recipesWithIngredients.add(spoonacularClient("/recipes/" + com.crauwjo.domain.recipe.getId() + query).get(Object.class));
//        } );
        //return recipesWithIngredients;
    }

}
