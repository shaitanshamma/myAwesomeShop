package ru.shaitanshamma.flow.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ru.shaitanshamma.configs.MailSendingConfig;
import ru.shaitanshamma.entities.*;
import ru.shaitanshamma.entities.dot.ProductDot;
import ru.shaitanshamma.services.*;
import ru.shaitanshamma.services.system.SystemUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderHandler {
    private static final Logger logger = LoggerFactory.getLogger(OrderHandler.class);

    private OrderAddressService orderAddressService;
    private ClientService clientService;
    private OrderService orderService;

    @Autowired
    public OrderHandler(OrderAddressService orderAddressService,
                        ClientService clientService,
                        OrderService orderService) {
        this.orderAddressService = orderAddressService;
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @Autowired
    public MailSendingConfig mailSendingConfig;

    @Autowired
    public CartService cartService;
    @Autowired
    public OrderListService orderListService;

    public OrderModel init() {
        return new OrderModel();
    }

    public void addBasicOrderInfo(OrderModel orderModel, BasicOrderInfo basicOrderInfo) {
        orderModel.setBasicOrderInfo(basicOrderInfo);
    }

    public void addAdressInfo(OrderModel orderModel, AddressInfo addressInfo) {
        orderModel.setAddressInfo(addressInfo);
    }

    public void save(OrderModel orderModel) throws IOException {
        OrderAdress orderAdress = new OrderAdress();
        Order order;
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
        order = orderService.makeOrder(client.get());
        saveOrderList(order);
        orderAddressService.save(orderAdress);
        /*
        Need insert user pass to email confiq
        mailSendingConfig.sendSimpleMessage(user.get().getEmail(),"New order", "You create new order!");
        */
    }

    public void saveOrderList(Order order) throws IOException {
        List<ProductDot> productDotList = new ArrayList<>();
        cartService.findAllItems().keySet().stream().forEach(pi -> productDotList.add(pi.getProduct()));
        for (ProductDot p : productDotList
        ) {
            OrderList orderList = new OrderList();
            Product product = new Product();
            product.setId(p.getId());
            product.setCategories(p.getCategories());
            product.setTitle(p.getTitle());
            product.setAbout(p.getAbout());
            product.setQuantity(p.getQuantity());
            product.setBrand(p.getBrand());
            product.setPrice(p.getPrice());
            if (p.getNewPictures() != null) {
                for (MultipartFile newPicture : p.getNewPictures()) {
                    if (product.getPictures() == null) {
                        product.setPictures(new ArrayList<>());
                    }
                    product.getPictures().add(new Picture(newPicture.getOriginalFilename(),
                            newPicture.getContentType(), new PictureData(newPicture.getBytes())));
                }
            }
            orderList.setProduct(product);
            orderList.setItemPrice(product.getPrice());
            orderList.setOrder(order);
            orderList.setQuantity(product.getQuantity());
            orderList.setTotalPrice(cartService.getSubTotal());
            orderListService.save(orderList);
        }
    }
}
