package com.example.demo.cats.cat;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class CatId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected CatId() {
   }

   public CatId(UUID id) {
       super(id);
   }
}