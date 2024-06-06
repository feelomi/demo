package com.example.demo.cats.cat;

import java.time.LocalDate;

public class CreateCatParameters {

    private final CatName catName;
    private final Gender gender;
    private final LocalDate birthday;
    private final Species species;

    public CreateCatParameters(CatName catName, Gender gender, LocalDate birthday, Species species) {
        this.catName = catName;
        this.gender = gender;
        this.birthday = birthday;
        this.species = species;
    }

    public CatName getCatName() {
        return catName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Species getSpecies() {
        return species;
    }
}
