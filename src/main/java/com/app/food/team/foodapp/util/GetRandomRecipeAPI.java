package com.app.food.team.foodapp.util;

import com.app.food.team.foodapp.model.FoodItem;
import com.app.food.team.foodapp.model.ResponseRecipeList;
import com.google.gson.Gson;
import org.springframework.lang.Nullable;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;



public class GetRandomRecipeAPI {
    public static void main(String[] args) throws Exception {
        ResponseRecipeList responseObj = new ResponseRecipeList();
        int howMany = 2;

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.spoonacular.com/recipes/random"+"?number="+howMany))
                .header("x-api-key","e2c5db0a94124421a628fdc66a0d6e62")
                .GET()
                .build();
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
//        System.out.println(getResponse.body());

        // parse response into FoodItem object
        // using a wrapper class because random/recipes requests return a "recipes" list
        // other request types may be able to go directly into FoodItem object
        responseObj = gson.fromJson(getResponse.body(),ResponseRecipeList.class);
        System.out.println(responseObj);
    }
}