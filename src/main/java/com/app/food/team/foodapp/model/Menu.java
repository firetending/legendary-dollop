package com.app.food.team.foodapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "menus")
//@AllArgsConstructor
//@NoArgsConstructor
public class Menu extends AbstractEntity {

    //TODO organization id, @ManyToOne
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private @NonNull @Getter List<Item> menuItems = new ArrayList<>();

    private @Getter @Setter String title;
    @Temporal(TemporalType.TIMESTAMP)
    private final @Getter LocalDateTime createdDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter LocalDateTime editedDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter LocalDateTime startDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private @Getter @Setter LocalDateTime endDateTime;

    public Menu(List<Item> menuItems) {
        this.menuItems = menuItems;
        this.createdDateTime = LocalDateTime.now();
        setEditedDateTime();
        this.title = generateRandomString();
    }

    public Menu() {
        this.createdDateTime = LocalDateTime.now();
        setEditedDateTime();
        this.title = generateRandomString();
    }

    public void setMenuItems(List<Item> menuItems) {
        this.menuItems = menuItems;
        setEditedDateTime();
    }

    private void setEditedDateTime() {
        this.editedDateTime = LocalDateTime.now();;
    }

    private String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
}

//- Menu ID (PK)
//- Organization ID (FK)
//- Title
//- Dates