package com.example.demo.cats.cat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CatService {

  Cat createCat(CreateCatParameters parameters);

    Optional<Cat> getCat(CatId catId);

    Page<Cat> getCats(Pageable pageable);

    boolean catWithNameExists(CatName catName);

    Cat editCat(CatId catId, EditCatParameters catParameters);

    void deleteCat(CatId catId);
}
