package ru.shaitanshamma.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Category;

import java.util.List;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAll();
}
