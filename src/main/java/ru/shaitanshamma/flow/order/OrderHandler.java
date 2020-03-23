package ru.shaitanshamma.flow.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.shaitanshamma.configs.MailSendingConfig;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.OrderAdress;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.OrderAddressService;
import ru.shaitanshamma.services.OrderService;
import ru.shaitanshamma.services.impl.CartServiceImpl;
import ru.shaitanshamma.services.system.SystemUser;

import java.util.Optional;


public class OrderHandler {
    private static final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private OrderAddressService orderAddressService;
    private ClientService clientService;
    private OrderService orderService;

    @Autowired
    public OrderHandler(OrderAddressService orderAddressService,
                        ClientService clientService,
                        OrderService orderService){
        this.orderAddressService = orderAddressService;
        this.clientService = clientService;
        this.orderService = orderService;
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
        Optional<SystemUser> user = clientService.findByName(orderModel.getBasicOrderInfo().getFirstName());
        Optional<Client> client = clientService.findClientByName(orderModel.getBasicOrderInfo().getFirstName());
        orderAdress.setIdClient(user.get().getId());
        orderAddressService.save(orderAdress);
        orderService.makeOrder(client.get());
        mailSendingConfig.sendSimpleMessage(user.get().getEmail(),"New order", "You create new order!");
    }
}
