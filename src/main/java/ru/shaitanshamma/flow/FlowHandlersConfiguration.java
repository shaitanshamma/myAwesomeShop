package ru.shaitanshamma.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shaitanshamma.flow.register.UserRegisterHandler;
import ru.shaitanshamma.services.ClientService;

@Configuration
public class FlowHandlersConfiguration {

    @Bean
    public UserRegisterHandler userRegisterHandler(ClientService userService) {
        return new UserRegisterHandler(userService);
    }
}
