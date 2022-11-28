package com.app.food.team.foodapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")
public class ItemIngredient extends AbstractEntity {

    @ManyToOne
    @JoinColumn(insertable = false,updatable = false)
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


//        {
//        "text": "string",
//        "quantity": 0,
//        "measure": "string",
//        "food": "string",
//        "weight": 0,
//        "foodId": "string"
//        }