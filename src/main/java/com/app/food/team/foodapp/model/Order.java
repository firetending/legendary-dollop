package com.app.food.team.foodapp.model;

import jakarta.persistence.Entity;
import java.util.Date;

//@Entity
public class Order extends AbstractEntity{
    //TODO userId from authentication, @ManyToMany
    //TODO itemId, @ManyToMany
    //TODO menuId, @ManyToMany //assumes meal periods (brk,lun,din) are separate menus
    //TODO transactionID, @OneToOne //payment
    private Date createdDateTime;
}

//- Order ID (PK)
//- User ID (FK)
//- Organization ID (FK) (?)
//- Menu ID (FK) (?)
//- Transaction ID (FK)
//- Date
//- Time

