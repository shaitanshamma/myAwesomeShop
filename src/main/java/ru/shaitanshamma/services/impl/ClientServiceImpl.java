package ru.shaitanshamma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.repositories.ClientRepository;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.ClientService;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Client findByLogin(String login) {
        return null;
    }

    @Override
    public boolean save(Client client) {
        return false;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll().stream()
                .map(Client::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
