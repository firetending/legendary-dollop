package com.app.food.team.foodapp.model.ordermodel;

import com.app.food.team.foodapp.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
//@Entity
public class Order extends AbstractEntity {
    //TODO userId from authentication, @ManyToMany
    //TODO itemId, @ManyToMany
    //TODO menuId, @ManyToOne //@ManyToMany if multiple meals/periods can be ordered at once
    //TODO transactionID, @OneToOne //payment

    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE) //no setter
    private LocalDateTime createdDateTime;
}

