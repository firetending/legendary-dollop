package com.app.food.team.foodapp.repository.menureciperepository;

import com.app.food.team.foodapp.model.menurecipemodel.TagDietLabel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDietLabelsRepository extends CrudRepository<TagDietLabel, Integer> {
}