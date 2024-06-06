package com.example.demo.cats.cat;

import jakarta.persistence.Embeddable;
import org.springframework.util.Assert;

import java.util.Objects;

@Embeddable
public class CatName {
    private String catName;

    protected CatName() {
    }

    public CatName(String catName) {
        Assert.hasText(catName, "Cat name cannot be blank");
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CatName userName = (CatName) o;
        return Objects.equals(catName, userName.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("catName", catName)
                .toString();
    }
}
