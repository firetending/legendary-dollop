package com.app.food.team.foodapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.Set;

//@Entity
public class Menu extends AbstractEntity {

    //TODO organization id, @ManyToOne

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Item> menuItems;

    private String title;
    private Date createdDateTime;
    private Date editedDateTime;
    private Date startDate;
    private Date endDate;

}

//- Menu ID (PK)
//- Organization ID (FK)
//- Title
//- Dates