package com.app.food.team.foodapp.model.menurecipemodel;

import com.app.food.team.foodapp.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item extends AbstractEntity {

    private String externalId; //parse from uri; api doc says field exists but doesn't respond with it
    @NonNull
    private String uri; //edamam path, have to parse id after #  http://www.edamam.com/ontologies/edamam.owl#recipe_b5e1c34c9042a35a534069f438ec86fc
    @NonNull
    private String label; //recipe title
    @Column(length=3000)
    @NonNull
    private String image;

    //TODO "images" field from EdamamAPI holding multiple sizes

    private int yield;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @NonNull
    private TagDietLabel[] dietLabels;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @NonNull
    private List<ItemIngredient> ingredients = new ArrayList<>();
    private int calories;
    private int glycemicIndex;
    private float totalWeight;

    //TODO data structure for tags like healthLabels, cautions, etc
//    @ManyToOne
//    @NonNull
//    private Set<TagHealthLabel> healthLabels;
//    @ManyToOne
//    @NonNull
//    private Set<TagCautionLabel> cautions;
//    @Column(length = 1000)
//    @NonNull
//    private List<String> ingredientLines;
//    @ManyToOne
//    @NonNull
//    private Set<TagCuisineType> cuisineType;
//    @ManyToOne
//    @NonNull
//    private Set<TagMealType> mealType;
//    @ManyToOne
//    @NonNull
//    private Set<TagDishType> dishType;

    //TODO "instructions" from EdamamAPI, array of strings

    public boolean setExternalId() {
        this.externalId = this.uri.substring(this.uri.indexOf('#')+1);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Item item = (Item) o;

        return getUri().equals(item.getUri());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getUri().hashCode();
        return result;
    }

}