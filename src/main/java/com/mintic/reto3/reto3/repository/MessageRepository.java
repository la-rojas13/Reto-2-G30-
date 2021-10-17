package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Message;
import com.mintic.reto3.reto3.repository.CRUD.MessageCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrud messageCrud;

    public List<Message> getAll(){
        return (List<Message>)messageCrud.findAll();
    }

    public Optional<Message>getMessage(int id){
        return messageCrud.findById(id);
    }
    
    public Message save(Message message){
        return messageCrud.save(message);
    }
}
