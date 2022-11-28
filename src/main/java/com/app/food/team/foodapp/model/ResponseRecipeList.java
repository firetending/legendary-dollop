package com.app.food.team.foodapp.model;

import java.util.List;


public class ResponseRecipeList {
    private List<Item> recipes;

    public List<Item> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Item> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "ResponseRecipeList{" +
                "recipes=" + recipes +
                '}';
    }
}
