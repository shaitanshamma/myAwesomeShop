package ru.shaitanshamma.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shaitanshamma.entities.Client;

import java.util.List;

public interface ClientService extends UserDetailsService {

    Client findById(Long id);

    Client findByLogin(String login);

    boolean save(Client client);

    List<Client> findAll();

}
