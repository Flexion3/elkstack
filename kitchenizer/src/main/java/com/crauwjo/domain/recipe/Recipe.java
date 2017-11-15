package com.crauwjo.domain.recipe;

import com.crauwjo.domain.ingredient.Ingredient;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "kitchenizer", type = "recipes")
public class Recipe {
    @Id
    private String id;
    private String title;
    private String image;
    private List<String> imageUrls;
    private Integer readyInMinutes;
    private List<Ingredient> extendedIngredients;

    public Recipe(){}

    public Recipe(String id, String title, String image, List<String> imageUrls, Integer readyInMinutes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageUrls = imageUrls;
        this.readyInMinutes = readyInMinutes;
    }

    public Recipe(String id, String title, String image, List<String> imageUrls, Integer readyInMinutes, List<Ingredient> extendedIngredients) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageUrls = imageUrls;
        this.readyInMinutes = readyInMinutes;
        this.extendedIngredients = extendedIngredients;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public List<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }
}
