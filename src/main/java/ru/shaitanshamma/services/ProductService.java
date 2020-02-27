package ru.shaitanshamma.services;

import ru.shaitanshamma.entities.dot.ProductDot;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<ProductDot> findAll();

    ProductDot findById(Long id);

    void deleteById(Long id);

    void save(ProductDot productDot) throws IOException;
}
