package com.mintic.reto3.reto3.repository.CRUD;

import com.mintic.reto3.reto3.model.Client;


import org.springframework.data.repository.CrudRepository;

public interface ClientCrud extends CrudRepository <Client,Integer> {
    
}
