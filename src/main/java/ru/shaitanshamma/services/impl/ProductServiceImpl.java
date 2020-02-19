package ru.shaitanshamma.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ru.shaitanshamma.entities.Product;
import ru.shaitanshamma.entities.dot.ProductDot;
import ru.shaitanshamma.repositories.ProductRepository;
import ru.shaitanshamma.services.ProductService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductDot> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDot::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDot findById(Long id) {
        return new ProductDot(productRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(ProductDot productDot) throws IOException {
        Product product = (productDot.getId() != null) ? productRepository.findById(productDot.getId()).get()
                : new Product();
        product.setTitle(productDot.getTitle());
        product.setCategory(productDot.getCategory());
        product.setBrand(productDot.getBrand());
        product.setPrice(productDot.getPrice());
//        if (productDot.getNewPictures() != null) {
//            for (MultipartFile newPicture : productDot.getNewPictures()) {
//                logger.info("Product {} file {} size {}", product.getId(),
//                        newPicture.getOriginalFilename(), newPicture.getSize());
//
//                if (product.getPictures() == null) {
//                    product.setPictures(new ArrayList<>());
//                }
//
//                product.getPictures().add(new Picture(newPicture.getOriginalFilename(),
//                        newPicture.getContentType(), new PictureData(newPicture.getBytes())));
//            }
//        }
        productRepository.save(product);
    }
}
