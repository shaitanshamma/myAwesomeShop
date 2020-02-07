package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.shaitanshamma.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("from Role r where name = :name")
    Role findOneByName(String name);
}
