package com.app.food.team.foodapp.repository;

import com.app.food.team.foodapp.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Integer> {
}
