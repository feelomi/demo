package com.example.demo;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.example.demo.cats.cat.*;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

    private final Faker faker = new Faker();

    private final CatService catService;

    public DatabaseInitializer(CatService catService) {
        this.catService = catService;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 20; i++) {
            catService.createCat(newRandomNameParameters());
        }
    }

    private CreateCatParameters newRandomNameParameters() {
        CatName catName = faker.catName();
        Gender gender = faker.bool().bool() ? Gender.MALE : Gender.FEMALE;
        LocalDate birthday = LocalDate.ofInstant(faker.date().birthday(10, 40).toInstant(), ZoneId.systemDefault());
        Species species = new Species(faker.spesies());
        return new CreateCatParameters(catName, gender, birthday, species);
    }
}


