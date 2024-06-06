package com.example.demo.cats;

import com.example.demo.cats.cat.Gender;
import jakarta.validation.constraints.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

    @NotExistingCat(groups = CatValidationGroupTwo.class)
    public class CreateCatFromData {

        @Size(min = 2, max = 200, groups = CatValidationGroupOne.class)
        private String catName;
        @NotNull
        private Gender gender;

        @Species(groups = CatValidationGroupOne.class)
        private String email;
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthday;

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getSpecies() {
            return email;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }


        public CreateCatParameters toParameters() {
            return new CreateCatParameters(new CatName(catName),
                    gender,
                    birthday,
                    species);
        }
    }

