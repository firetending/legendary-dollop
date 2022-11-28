package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.model.Item;
import com.app.food.team.foodapp.model.ResponseWrapper;
import com.app.food.team.foodapp.repository.ItemRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item createItem(@RequestBody ResponseWrapper responseObj) {
//        if (errors.hasErrors()) {
//        }
        Gson gson = new GsonBuilder().create();

        // parse into Item object
        // edamam recipe json is an outer object {"recipe":{recipe Json object}}
        // using a wrapper class to let gson deserialize the inner object
//        ResponseWrapper responseObj = gson.fromJson(itemJson, ResponseWrapper.class);
        Item newItem = gson.fromJson(responseObj.getRecipe(),Item.class);
//        newItem.setExternalId(); //has to parse id from uri field
        itemRepo.save(newItem);
        return newItem;
    }
}
