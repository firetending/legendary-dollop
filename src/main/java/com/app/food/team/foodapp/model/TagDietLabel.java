package com.app.food.team.foodapp.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class TagDietLabel extends AbstractRecipeTag {
    public TagDietLabel() {
        super();
    }

    public TagDietLabel(String tag) {
        super(tag);
    }

}
