package com.app.food.team.foodapp.model;

import java.util.List;

public class ResponseRecipeList {
    private List<FoodItem> recipes;

    public List<FoodItem> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<FoodItem> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "ResponseRecipeList{" +
                "recipes=" + recipes +
                '}';
    }
}
