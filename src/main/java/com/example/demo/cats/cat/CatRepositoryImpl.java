package com.example.demo.cats.cat;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class CatRepositoryImpl implements CatRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public CatRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public CatId nextId() {
        return new CatId(generator.getNextUniqueId());
    }
}