package com.example.demo.cats.cat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tt_cat")
public class Cat extends Abstract  VersionedEntity<CatId> {

    @NotNull
    private CatName catName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private LocalDate birthday;


    @NotNull
    private Species species;

    /**
     * Default constructor for JPA
     */
    protected Cat () {
    }

    public Cat (CatId id,
            CatName catName,
            Gender gender,
            LocalDate birthday,
            Species species) {
        super(id);
        this.catName = catName;
        this.gender = gender;
        this.birthday = birthday;
        this.species = species;
    }

    public CatName getCatNameName() {
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

    public void setCatName(CatName catName) {
        this.catName = catName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}