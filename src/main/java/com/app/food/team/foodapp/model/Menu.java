package com.app.food.team.foodapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menus")
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends AbstractEntity {

    //TODO organization id, @ManyToOne
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private @NonNull @Getter @Setter List<Item> menuItems = new ArrayList<>();

    private String title;
    private Date createdDateTime;
    private Date editedDateTime;
    private Date startDate;
    private Date endDate;

    public Menu(List<Item> menuItems) {
        this.menuItems = menuItems;
    }
}

//- Menu ID (PK)
//- Organization ID (FK)
//- Title
//- Dates