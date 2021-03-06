package ru.shaitanshamma.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shaitanshamma.flow.order.OrderHandler;
import ru.shaitanshamma.flow.register.UserRegisterHandler;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.OrderAddressService;
import ru.shaitanshamma.services.OrderService;
import ru.shaitanshamma.services.impl.CartServiceImpl;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(ClientService userService) {
        return new UserRegisterHandler(userService);
    }

    @Bean
    public OrderHandler orderHandler(OrderAddressService addressService,
                                     ClientService clientService,
                                     OrderService orderService,
                                     CartServiceImpl cartService) {
        return new OrderHandler(addressService, clientService, orderService, cartService);
    }
}
