package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("from Role r where name = :name")
    Role findOneByName(String name);
}
