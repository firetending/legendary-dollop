package com.app.food.team.foodapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@NoArgsConstructor
//@AllArgsConstructor
public class ItemIngredient extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(insertable = false,updatable = false)
    private @Getter @Setter Item item;
    private @Getter @Setter String text;
    private @Getter @Setter int quantity;
    private @Getter @Setter String measure;
    private @Getter @Setter String food;
    private @Getter @Setter int weight;
    private @Getter @Setter String foodId;

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


//        {
//        "text": "string",
//        "quantity": 0,
//        "measure": "string",
//        "food": "string",
//        "weight": 0,
//        "foodId": "string"
//        }