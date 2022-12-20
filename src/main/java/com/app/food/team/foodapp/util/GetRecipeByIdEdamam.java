package com.app.food.team.foodapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRecipeByIdEdamam {

    public static void main(String[] args) throws Exception {
        String appId = "5af3ae0a";
        String appKey = "1bf2959a73a85fa063cd713ec55636c5";
        String keys = "?type=public&app_id="+appId+"&app_key="+appKey;
        String recipeId = "recipe_b5e1c34c9042a35a534069f438ec86fc";
        String fields = "&field=uri&field=label&field=image&field=images&field=source&field=url" +
                "&field=shareAs&field" +
                "=yield&field=dietLabels&field=healthLabels&field=cautions&field=ingredientLines&field=ingredients&field=calories&field=glycemicIndex&field=totalCO2Emissions&field=co2EmissionsClass&field=totalWeight&field=totalTime&field=cuisineType&field=mealType&field=dishType&field=tags";

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.edamam.com/api/recipes/v2/"+recipeId+keys+fields))
                .GET()
                .build();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());
    }
}
