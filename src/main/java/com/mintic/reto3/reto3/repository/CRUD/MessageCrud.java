package com.mintic.reto3.reto3.repository.CRUD;

import com.mintic.reto3.reto3.model.Message;

import org.springframework.data.repository.CrudRepository;

public interface MessageCrud extends CrudRepository <Message,Integer> {
    
}
