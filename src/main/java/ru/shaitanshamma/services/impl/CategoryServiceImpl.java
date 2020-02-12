package ru.shaitanshamma.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Category;
import ru.shaitanshamma.repositories.CategoryRepository;
import ru.shaitanshamma.services.EntitiesService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements EntitiesService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
}
