package ru.shaitanshamma.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shaitanshamma.repositories.ProductRepository;
import ru.shaitanshamma.services.impl.ProductServiceImpl;

@Configuration
public class ServiceConfiguration {

//    @Bean
//    public UserService userService(UserRepository userRepository, RoleRepository roleRepository,
//                                   BCryptPasswordEncoder passwordEncoder) {
//        return new UserServiceJpaImpl(userRepository, roleRepository, passwordEncoder);
//    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
