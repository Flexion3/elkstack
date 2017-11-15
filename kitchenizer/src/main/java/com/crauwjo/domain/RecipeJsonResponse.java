package com.crauwjo.domain;

import lombok.Value;
import com.crauwjo.domain.recipe.Recipe;

import java.math.BigInteger;
import java.util.List;

@Value
public class RecipeJsonResponse<T> {
    private List<Recipe> results;
    private String baseUri;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
    private Integer processingTimeMs;
    private BigInteger expires;
    private Boolean isStale;
}
