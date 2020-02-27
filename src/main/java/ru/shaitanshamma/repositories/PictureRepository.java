package ru.shaitanshamma.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.shaitanshamma.entities.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long>{

}
