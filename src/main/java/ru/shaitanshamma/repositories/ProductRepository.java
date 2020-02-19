package ru.shaitanshamma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
