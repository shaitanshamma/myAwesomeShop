package ru.shaitanshamma.services;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EntitiesService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(Long id);

}
