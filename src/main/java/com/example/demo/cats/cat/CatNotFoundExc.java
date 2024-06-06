package com.example.demo.cats.cat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatNotFoundExc extends RuntimeException {

    public CatNotFoundExc (CatId catId) {
        super(String.format("Cat with id %s not found", catId.toString()));
    }
}