package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

   @Query("from Role r where r.title = :name")
    Role findOneByTitle(String name);
}
