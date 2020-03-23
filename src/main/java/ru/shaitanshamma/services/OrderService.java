package ru.shaitanshamma.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Cart;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.Order;
import ru.shaitanshamma.repositories.OrderRepository;
import ru.shaitanshamma.services.system.SystemUser;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order makeOrder(Client client){
        Order order = new Order(client);
        return orderRepository.save(order);
    }

}
