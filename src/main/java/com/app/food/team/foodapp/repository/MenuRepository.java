package com.app.food.team.foodapp.repository;

import com.app.food.team.foodapp.model.Item;
import com.app.food.team.foodapp.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

}
