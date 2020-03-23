package ru.shaitanshamma.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.services.system.SystemUser;

import java.util.List;
import java.util.Optional;

public interface ClientService extends UserDetailsService {

    Optional<SystemUser> findById(Long id);

    Optional<SystemUser> findByName(String username);

    boolean existsUserByEmail(String email);

    boolean save(SystemUser systemUser);

    void delete(Long id);

    List<SystemUser> findAll();

    Optional<Client> findClientByName(String name);

}
