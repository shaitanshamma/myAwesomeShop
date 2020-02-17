package ru.shaitanshamma.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Cart;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.Product;
import ru.shaitanshamma.repositories.ProductRepository;

@Service
public class CartService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Cart addToCart(Product product, Client client){
        Cart cart = new Cart();
        cart.setIdClient(client.getId());
        cart.setIdProduct(product.getId());
        return cart;
    }
}
