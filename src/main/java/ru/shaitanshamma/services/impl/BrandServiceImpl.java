package ru.shaitanshamma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Brand;
import ru.shaitanshamma.repositories.BrandRepository;
import ru.shaitanshamma.services.EntitiesService;

import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceImpl implements EntitiesService {

    private BrandRepository brandRepository;

    @Autowired
    public void setBrandRepository(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return brandRepository.findById(id);
    }

    public Brand save(Brand brand){
        return brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
