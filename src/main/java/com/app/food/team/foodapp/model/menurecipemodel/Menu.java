package com.app.food.team.foodapp.model.menurecipemodel;

import com.app.food.team.foodapp.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "menus")
public class Menu extends AbstractEntity {

    //TODO? user id @ManyToOne
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(AccessLevel.NONE) //getter only, no setter
    @NonNull
    private List<Item> menuItems = new ArrayList<>();
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE) //getter only, no setter
    private final LocalDateTime createdDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime editedDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDateTime;

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