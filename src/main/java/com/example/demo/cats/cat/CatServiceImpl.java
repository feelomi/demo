package com.example.demo.cats.cat;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public Cat createCat(CreateCatParameters parameters) {
        CatId catId = catRepository.nextId();
        var cat = new Cat(
                catId,
                parameters.getCatName(),
                parameters.getGender(),
                parameters.getBirthday(),
                parameters.getSpecies()
        );
        return catRepository.save(cat);
    }

    @Override
    public Optional<Cat> getCat(CatId catId) {
        return catRepository.findById(catId);
    }

    @Override
    public Page<Cat> getCat(Pageable pageable) {
        return catRepository.findAll(pageable);
    }

    @Override
    public boolean catWithNameExists(CatName catName) {
        return catRepository.existsByCatName(catName);
    }

    @Override
    public Cat editCat(CatId catId, EditCatParameters teamMemberParameters) {
        var cat = catRepository
                .findById(catId)
                .orElseThrow(() -> new CatNotFoundExc(catId));
        if (catParameters.getVersion() != cat.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(Cat.class, cat.getId().asString());
        }
        teamMemberParameters.update(cat);
        return cat;
    }

    @Override
    public void deleteCat(CatId catId) {
        catRepository.deleteById(catId);
    }
}
