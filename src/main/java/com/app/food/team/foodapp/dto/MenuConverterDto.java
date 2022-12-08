package com.app.food.team.foodapp.dto;

import com.app.food.team.foodapp.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
//@SuperBuilder // https://en.wikipedia.org/wiki/Builder_pattern#Java
@JsonInclude(NON_NULL)  // https://www.javaguides.net/2019/04/jackson-jsoninclude-example.html
public class MenuConverterDto {

    protected List<RecipeApiWrapper> wrappedMenuItems;
    protected List<Item> menuItems = new ArrayList<>();
    protected Menu menu;

    public MenuConverterDto(List<RecipeApiWrapper> data) {
        this.wrappedMenuItems = data;
        for (RecipeApiWrapper wrappedRecipe : wrappedMenuItems) {
                RecipeDto recipeDto = new RecipeDto(wrappedRecipe.getRecipe());
                menuItems.add(recipeDto.getRecipe());
        }
        this.menu = new Menu(menuItems);
    }

    public MenuConverterDto(Menu menuObject) {
        for (Item recipe : menuObject.getMenuItems()) {
            RecipeApiWrapper wrappedRecipe = new RecipeApiWrapper(recipe);
            wrappedMenuItems.add(wrappedRecipe);
        }
    }
}
