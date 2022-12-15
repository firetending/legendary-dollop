package com.app.food.team.foodapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
@ToString
public class Item extends AbstractEntity {

    private String externalId; //parse from uri; api doc says field exists but doesn't respond with it

    @NonNull
    @EqualsAndHashCode.Include
    private String uri; //edamam path, have to parse id after #  http://www.edamam.com/ontologies/edamam.owl#recipe_b5e1c34c9042a35a534069f438ec86fc

    @NonNull
    private String label; //title

    @NonNull
    @Column(length=3000)
    private String image;

    private int yield;

    @NonNull
    @ManyToMany(cascade = CascadeType.PERSIST)
    private TagDietLabel[] dietLabels;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemIngredient> ingredients = new ArrayList<>();

    private int calories;

    private int glycemicIndex;

    private float totalWeight;

    @NonNull
    private List<String> tags;


    public boolean setExternalId() {
        this.externalId = this.uri.substring(this.uri.indexOf('#')+1);
        return true;
    }
    public String getExternalId() { return externalId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Item item = (Item) o;//
        return getUri().equals(item.getUri());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getUri().hashCode();
        return result;
    }

//    @Override
//    public String toString() {
//        return "Item{" +
//                "\nexternalId='" + externalId + '\'' +
//                ",\nuri='" + uri + '\'' +
//                ",\nlabel='" + label + '\'' +
//                ",\nimage='" + image + '\'' +
//                ",\nyield=" + yield +
//                ",\ndietLabels=" + dietLabels +
//                ",\nhealthLabels=" + healthLabels +
//                ",\ncautions=" + cautions +
//                ",\ningredientLines=" + ingredientLines +
//                ",\ningredients=" + ingredients +
//                ",\ncalories=" + calories +
//                ",\nglycemicIndex=" + glycemicIndex +
//                ",\ntotalWeight=" + totalWeight +
//                ",\ncuisineType=" + cuisineType +
//                ",\nmealType=" + mealType +
//                ",\ndishType=" + dishType +
//                ",\ntags=" + tags +
//                '}';
//    }
}
