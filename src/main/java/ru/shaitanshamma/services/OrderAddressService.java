package ru.shaitanshamma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.OrderAdress;
import ru.shaitanshamma.repositories.OrderAdressRepository;

@Service
public class OrderAddressService {
    private OrderAdressRepository orderAdressRepository;

    @Autowired
    public void setOrderAdressRepository(OrderAdressRepository orderAdressRepository){
        this.orderAdressRepository = orderAdressRepository;
    }

    public void save(OrderAdress orderAdress){
        orderAdressRepository.save(orderAdress);
    }
}
