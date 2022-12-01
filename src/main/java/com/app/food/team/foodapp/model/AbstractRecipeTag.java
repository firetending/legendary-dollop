package com.app.food.team.foodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractRecipeTag extends AbstractEntity {
//    @Column(unique = true)
    private String tag;

    public AbstractRecipeTag() {
    }

    public AbstractRecipeTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractRecipeTag that = (AbstractRecipeTag) o;

        return tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + tag.hashCode();
        return result;
    }
}
