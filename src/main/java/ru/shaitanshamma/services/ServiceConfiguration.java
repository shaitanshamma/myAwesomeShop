package ru.shaitanshamma.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.shaitanshamma.repositories.ClientRepository;
import ru.shaitanshamma.repositories.ProductRepository;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.impl.ClientServiceImpl;
import ru.shaitanshamma.services.impl.ProductServiceImpl;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ClientService userService(ClientRepository clientRepository, RoleRepository roleRepository,
                                   BCryptPasswordEncoder passwordEncoder) {
        return new ClientServiceImpl(clientRepository, roleRepository, passwordEncoder);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
