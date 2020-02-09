package ru.shaitanshamma.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.OrderAdress;

@Repository
public interface OrderAdressRepository extends CrudRepository<OrderAdress, Long> {

}
