package ru.shaitanshamma.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.shaitanshamma.services.system.SystemUser;

import java.util.List;

public interface UserService extends UserDetailsService {

    SystemUser findById(Long id);

    SystemUser findByUserName(String username);

    boolean save(SystemUser systemUser);

    void delete(Long id);

    List<SystemUser> findAll();
}