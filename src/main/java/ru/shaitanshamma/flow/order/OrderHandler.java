package ru.shaitanshamma.flow.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shaitanshamma.configs.MailSendingConfig;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.OrderAdress;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.OrderAddressService;
import ru.shaitanshamma.services.system.SystemUser;

import java.util.Optional;


public class OrderHandler {
    private static final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private OrderAddressService orderService;
    private ClientService clientService;

    @Autowired
    public OrderHandler(OrderAddressService orderService, ClientService clientService){
        this.orderService = orderService;
        this.clientService = clientService;
    }
    @Autowired
    public MailSendingConfig mailSendingConfig;

    public OrderModel init(){
        return new OrderModel();
    }

    public void addBasicOrderInfo(OrderModel orderModel, BasicOrderInfo basicOrderInfo){
        orderModel.setBasicOrderInfo(basicOrderInfo);
    }

    public void addAdressInfo(OrderModel orderModel, AddressInfo addressInfo){
        orderModel.setAddressInfo(addressInfo);
    }

    public void save(OrderModel orderModel){
        OrderAdress orderAdress = new OrderAdress();
        orderAdress.setAppartament(orderModel.getAddressInfo().getAppartaments());
        orderAdress.setCity(orderModel.getAddressInfo().getCity());
        orderAdress.setCountry(orderModel.getAddressInfo().getCountry());
        orderAdress.setPostIndex(orderModel.getAddressInfo().getZipCode());
        orderAdress.setRegion(orderModel.getAddressInfo().getRegion());
        orderAdress.setBuilding(orderModel.getAddressInfo().getBuilding());
        orderAdress.setStreet(orderModel.getAddressInfo().getStreet());
        orderModel.getBasicOrderInfo().getFirstName();
        Optional<SystemUser> client = clientService.findByName(orderModel.getBasicOrderInfo().getFirstName());
        orderAdress.setIdClient(client.get().getId());
        orderService.save(orderAdress);
        mailSendingConfig.sendSimpleMessage(client.get().getEmail(),"New order", "You create new order!");
    }
}
