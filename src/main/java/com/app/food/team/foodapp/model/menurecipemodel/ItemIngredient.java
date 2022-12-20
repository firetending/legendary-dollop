package com.app.food.team.foodapp.model.menurecipemodel;

import com.app.food.team.foodapp.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class ItemIngredient extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(insertable = false,updatable = false)
    private Item item;
    private String text;
    private int quantity;
    private String measure;
    private String food;
    private int weight;
    private String foodId;

    @Override
    public String toString() {
        return "ItemIngredient{" +
                "\ntext='" + text + '\'' +
                ",\nquantity=" + quantity +
                ",\nmeasure='" + measure + '\'' +
                ",\nfood='" + food + '\'' +
                ",\nweight=" + weight +
                ",\nfoodId='" + foodId + '\'' +
                '}';
    }
}