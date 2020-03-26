package ru.shaitanshamma.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shaitanshamma.entities.Client;
import ru.shaitanshamma.entities.Comment;
import ru.shaitanshamma.repositories.ClientRepository;
import ru.shaitanshamma.repositories.CommentRepository;
import ru.shaitanshamma.services.EntitiesService;

import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl extends Comment implements EntitiesService {

    private CommentRepository commentRepository;

    private ClientRepository clientRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

}
