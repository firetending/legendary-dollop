package com.app.food.team.foodapp.repository;

import com.app.food.team.foodapp.model.ItemIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemIngredientRepository extends CrudRepository<ItemIngredient,Integer> {
}
