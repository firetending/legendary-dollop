package com.app.food.team.foodapp.constants;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class AppConstants {
    private AppConstants(){}
    public static final String BASE_URL = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
    public static final String CONFIRMATION_BASE_URL = "http://localhost:3000/";
}
