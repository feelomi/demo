package com.example.demo.cats.cat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CatRepository extends CrudRepository<Cat, CatId>,
        PagingAndSortingRepository<Cat, CatId>,
        CatRepositoryCustom {

    boolean existsByCatName(CatName catName);
}