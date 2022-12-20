package com.app.food.team.foodapp.model.menurecipemodel;

public class RecipeApiWrapper {
    private Item recipe;

    public RecipeApiWrapper() {
    }
    public RecipeApiWrapper(Item recipe) {
        this.recipe = recipe;
    }

    public Item getRecipe() {
        return recipe;
    }

    public void setRecipe(Item recipe) {
        this.recipe = recipe;
    }


}
