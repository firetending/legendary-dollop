package com.app.food.team.foodapp.model.menurecipemodel;

import jakarta.persistence.Entity;

@Entity
public class TagDietLabel extends AbstractRecipeTag {
    public TagDietLabel() {
        super();
    }

    public TagDietLabel(String tag) {
        super(tag);
    }

}
