package ru.shaitanshamma.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Role;
import ru.shaitanshamma.repositories.RoleRepository;
import ru.shaitanshamma.services.EntitiesService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements EntitiesService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
