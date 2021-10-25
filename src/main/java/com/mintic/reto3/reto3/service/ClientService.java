package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Client;
import com.mintic.reto3.reto3.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> consult = clientRepository.getClient(client.getIdClient());
            if (consult.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> consult = clientRepository.getClient(client.getIdClient());
            if (!consult.isEmpty()) {
                if (client.getName() != null) {
                    consult.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    consult.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    consult.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    consult.get().setAge(client.getAge());
                }
                return clientRepository.save(consult.get());
            }
        }
        return client;
    }

    public boolean deleteClient(int id){
        Optional<Client> consult = clientRepository.getClient(id);
            if (!consult.isEmpty()) {
                clientRepository.delete(consult.get());
                return true;

            }
        return false;
    }
}
