package ru.shaitanshamma.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.OrderList;
import ru.shaitanshamma.repositories.OrderListRep;

@Service
public class OrderListService {

    @Autowired
    private OrderListRep orderListRep;

    public void save(OrderList orderList){
        orderListRep.save(orderList);
    }
}
