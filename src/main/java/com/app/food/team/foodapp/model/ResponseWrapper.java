package com.app.food.team.foodapp.model;

import com.google.gson.JsonObject;

public class ResponseWrapper {
    private Item recipe;

    public ResponseWrapper() {
    }
    public ResponseWrapper(Item recipe) {
        this.recipe = recipe;
    }

    public Item getRecipe() {
        return recipe;
    }

    public void setRecipe(Item recipe) {
        this.recipe = recipe;
    }


}
