package com.app.food.team.foodapp.dto.menurecipedto;
import com.app.food.team.foodapp.model.menurecipemodel.Item;
import com.app.food.team.foodapp.model.menurecipemodel.ItemIngredient;
import com.app.food.team.foodapp.model.menurecipemodel.TagDietLabel;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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
