package com.app.food.team.foodapp.model;

import com.google.gson.JsonObject;

public class ResponseWrapper {
    private JsonObject recipe;

    public JsonObject getRecipe() {
        return recipe;
    }

    public void setRecipe(JsonObject recipe) {
        this.recipe = recipe;
    }


}
