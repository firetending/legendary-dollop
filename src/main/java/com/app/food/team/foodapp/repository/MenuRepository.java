package com.app.food.team.foodapp.repository;

import com.app.food.team.foodapp.dto.MenuMetadataDTO;
import com.app.food.team.foodapp.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Query(value = "SELECT internal_id, title, created_date_time, edited_date_time FROM menus", nativeQuery = true)
    List<Map<String,Object>> getAllMenuMetadata();

//    @Query(value = "SELECT internal_id, title FROM menus", nativeQuery = true)
//    List<MenuMetadataDTO> getAllMenuMetadata();

//    @Query("SELECT NEW com.app.food.team.foodapp.dto.MenuMetadataDTO(m.internal_id, m.title, m" +
//            ".created_date_time, m.edited_date_time) FROM " +
//            "menus m")
//    MenuMetadataDTO getAllMenuMetadata();
}
