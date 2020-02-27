package ru.shaitanshamma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.Role;
import ru.shaitanshamma.repositories.ClientRepository;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.ClientService;
import ru.shaitanshamma.services.system.SystemUser;

import javax.transaction.Transactional;
import java.util.*;
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
    @Transactional
    public SystemUser findById(Long id) {
        return new SystemUser(clientRepository.findById(id).get());
    }

    @Override
    @Transactional
    public SystemUser findByName(String name) {
        Client client = clientRepository.findOneByName(name);
        return new SystemUser(client.getName(), client.getLastName(), client.getPassword(),
                client.getPassword(), client.getEmail(), client.getPhone());
    }

    @Override
    @Transactional
    public boolean save(SystemUser systemUser) {
        Client client = systemUser.getId() != null ? clientRepository
                .findById(systemUser.getId())
                .orElse(new Client()) : new Client();
        client.setName(systemUser.getName());
        if (systemUser.getId() == null || (systemUser.getPassword() != null && !systemUser.getPassword().trim().isEmpty())) {
            client.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        }
        client.setLastName(systemUser.getLastName());
        client.setEmail(systemUser.getEmail());
        client.setLogin(systemUser.getLogin());
        client.setPhone(systemUser.getPhone());
        client.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findOneByTitle("ROLE_CLIENT"))));
       // client.setRoles(new HashSet<>(Collections.singletonList(roleRepository.findOneByTitle("ROLE_ADMIN"))));
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return clientRepository.existsUserByEmail(email);
    }

    @Override
    public List<SystemUser> findAll() {
        return
                clientRepository.findAll().stream()
                        .map(SystemUser::new)
                        .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SystemUser user = findByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }
}
