package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Computer;
import com.mintic.reto3.reto3.repository.CRUD.ComputerCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepository {

    @Autowired
    private ComputerCrud computerCrud;

    public List<Computer> getAll(){
        return (List<Computer>)computerCrud.findAll();
    }

    public Optional<Computer>getComputer(int id){
        return computerCrud.findById(id);
    }
    
    public Computer save(Computer computer){
        return computerCrud.save(computer);
    }
    
    public void delete(Computer computer){
       computerCrud.delete(computer);
    }
}
