package com.example.demo.cats.cat;

import java.time.LocalDate;

public class EditCatParameters extends CreateCatParameters {

    private final long version;

    public EditCatParameters(long version, CatName catName, Gender gender, LocalDate birthday, Species species) {
        super(catName, gender, birthday, species);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void update(Cat cat) {
        cat.setCatName(getCatName());
        cat.setGender(getGender());
        cat.setBirthday(getBirthday());
        cat.setSpecies(getSpecies());
    }
}
