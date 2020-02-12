package ru.shaitanshamma.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
