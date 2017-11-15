package com.crauwjo.persistence;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.crauwjo.domain.recipe.Recipe;


@Repository
public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {
}
