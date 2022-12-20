package com.app.food.team.foodapp.repository.menureciperepository;

import com.app.food.team.foodapp.model.menurecipemodel.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    boolean existsByUri(String uri);
    boolean existsByExternalId(String externalId);
    Item findByExternalId(String externalId);

    Item findByUri(String uri);
}
