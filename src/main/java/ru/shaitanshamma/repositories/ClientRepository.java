package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.shaitanshamma.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    //@Query("from Client c join fetch c.roles r where c.name = :name")
    Client findOneByName(String name);

    void deleteById(Long id);

    boolean existsUserByEmail(String email);
}
