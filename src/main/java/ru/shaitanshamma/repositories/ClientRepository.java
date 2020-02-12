package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaitanshamma.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByLogin(String login);

    Client findOneByUserName(String username);
}
