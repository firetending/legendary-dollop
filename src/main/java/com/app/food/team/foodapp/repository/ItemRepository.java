package com.app.food.team.foodapp.repository;

import com.app.food.team.foodapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    boolean existsByUri(String uri);
    boolean existsByExternalId(String externalId);
    Item findByExternalId(String externalId);

    Item findByUri(String uri);
}