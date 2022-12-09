package com.app.food.team.foodapp.dto;

import com.app.food.team.foodapp.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
//@SuperBuilder // https://en.wikipedia.org/wiki/Builder_pattern#Java
@JsonInclude(NON_NULL)  // https://www.javaguides.net/2019/04/jackson-jsoninclude-example.html
public class MenuConverterDto {
    @Expose //field to be serialized by Gson
    protected int internalId;
    @SerializedName("menuItemList")
    @Expose
    protected List<RecipeApiWrapper> wrappedMenuItemsForJSON = new ArrayList<>();
    protected List<Item> menuItems = new ArrayList<>();
    protected Menu menu;

    public MenuConverterDto(List<RecipeApiWrapper> data) {
        this.wrappedMenuItemsForJSON = data;
        for (RecipeApiWrapper wrappedRecipe : wrappedMenuItemsForJSON) {
                RecipeDto recipeDto = new RecipeDto(wrappedRecipe.getRecipe());
                menuItems.add(recipeDto.getRecipe());
        }
        this.menu = new Menu(menuItems);
    }

    public MenuConverterDto(Menu menuObject) {
        for (Item recipe : menuObject.getMenuItems()) {
            RecipeApiWrapper wrappedRecipe = new RecipeApiWrapper(recipe);
            this.wrappedMenuItemsForJSON.add(wrappedRecipe);
            this.internalId = menuObject.getInternalId();
        }
    }
}
