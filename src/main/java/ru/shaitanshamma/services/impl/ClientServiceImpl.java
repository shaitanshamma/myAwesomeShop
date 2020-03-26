package ru.shaitanshamma.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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
    private final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

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
    public Optional<SystemUser> findById(Long id) {
        return clientRepository.findById(id).map(SystemUser::new);
    }

    @Override
    @Transactional
    public Optional<SystemUser> findByName(String username) {
        return clientRepository.findOneByName(username).map(SystemUser::new);
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
    public Optional<Client> findClientByName(String name) {
        return clientRepository.findOneByName(name);
    }


    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<SystemUser> user = findByName(userName);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        try {
            return new org.springframework.security.core.userdetails.User(user.get().getName(), user.get().getPassword(),
                    mapRolesToAuthorities(user.get().getRoles()));
        } catch (Exception ex) {
            logger.error("", ex);
            throw new BadCredentialsException("Internal error. Try again latter.");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());
    }
}
