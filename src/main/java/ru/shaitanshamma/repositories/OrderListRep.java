package ru.shaitanshamma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.OrderList;

@Repository
public interface OrderListRep extends JpaRepository<OrderList, Long> {
}
