package com.app.food.team.foodapp.enums;



public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    public final String label;

    private Role(String label){
        this.label = label;
    }
}