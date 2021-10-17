package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Client;
import com.mintic.reto3.reto3.repository.CRUD.ClientCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrud clientCrud;

    public List<Client> getAll(){
        return (List<Client>)clientCrud.findAll();
    }

    public Optional<Client>getClient(int id){
        return clientCrud.findById(id);
    }
    
    public Client save(Client client){
        return clientCrud.save(client);
    }
}
