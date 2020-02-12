package ru.shaitanshamma.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Order;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
