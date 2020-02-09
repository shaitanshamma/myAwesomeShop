package ru.shaitanshamma.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shaitanshamma.entities.Comment;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
