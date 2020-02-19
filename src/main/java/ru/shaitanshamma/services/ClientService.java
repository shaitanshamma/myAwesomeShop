package ru.shaitanshamma.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shaitanshamma.services.system.SystemUser;

import java.util.List;

public interface ClientService extends UserDetailsService {

    SystemUser findById(Long id);

    SystemUser findByName(String name);

    boolean save(SystemUser systemUser);

    List<SystemUser> findAll();

    void delete(Long id);

}
