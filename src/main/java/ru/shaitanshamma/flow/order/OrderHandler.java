package ru.shaitanshamma.flow.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shaitanshamma.entities.Order;
import ru.shaitanshamma.entities.OrderAdress;
import ru.shaitanshamma.services.OrderAddressService;
import ru.shaitanshamma.services.OrderService;


public class OrderHandler {
    private static final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private OrderAddressService orderService;

    @Autowired
    public OrderHandler(OrderAddressService orderService){
        this.orderService = orderService;
    }

    public OrderModel init(){
        return new OrderModel();
    }

    public void addBasicOrderInfo(OrderModel orderModel, BasicOrderInfo basicOrderInfo){
        orderModel.setBasicOrderInfo(basicOrderInfo);
    }

    public void addAdressInfo(OrderModel orderModel, AdressInfo adressInfo){
        orderModel.setAdressInfo(adressInfo);
    }

    public void save(OrderModel orderModel){
        OrderAdress orderAdress = new OrderAdress();
        orderAdress.setAppartament(orderModel.getAdressInfo().getAppartaments());
        orderAdress.setCity(orderModel.getAdressInfo().getCity());
        orderAdress.setCountry(orderModel.getAdressInfo().getCountry());
        orderAdress.setPostIndex(orderModel.getAdressInfo().getZipCode());
        orderAdress.setRegion(orderModel.getAdressInfo().getRegion());
        orderAdress.setBuilding(orderModel.getAdressInfo().getBuilding());
        orderAdress.setStreet(orderModel.getAdressInfo().getStreet());
        orderService.save(orderAdress);
    }
}
