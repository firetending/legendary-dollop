package com.app.food.team.foodapp.dto;
import com.app.food.team.foodapp.model.Item;
import com.app.food.team.foodapp.model.ItemIngredient;
import com.app.food.team.foodapp.model.TagDietLabel;
import com.app.food.team.foodapp.repository.ItemRepository;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

//@Data
//@SuperBuilder // https://en.wikipedia.org/wiki/Builder_pattern#Java
@JsonInclude(NON_NULL)  // https://www.javaguides.net/2019/04/jackson-jsoninclude-example.html
public class RecipeDto {
    protected @Getter @Setter Item recipe;
    protected final @Getter boolean externalIdWasSet;
    protected @Getter @Setter TagDietLabel[] dietLabels;
    protected @Getter @Setter ItemIngredient[] ingredients;

    // TODO if item already exists, replace recipe with existing persistent item
    public RecipeDto(@NotNull Item recipe) {
        this.recipe = recipe;
        this.externalIdWasSet = recipe.setExternalId();
//        this.dietLabels = this.recipe.getDietLabels();
//        this.ingredients = this.recipe.getIngredients();
    }
}
