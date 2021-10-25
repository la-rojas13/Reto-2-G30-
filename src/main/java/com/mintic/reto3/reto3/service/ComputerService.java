package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Computer;
import com.mintic.reto3.reto3.repository.ComputerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll() {
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id) {
        return computerRepository.getComputer(id);
    }

    public Computer save(Computer computer) {
        if (computer.getId() == null) {
            return computerRepository.save(computer);
        } else {
            Optional<Computer> consult = computerRepository.getComputer(computer.getId());
            if (consult.isEmpty()) {
                return computerRepository.save(computer);
            } else {
                return computer;
            }
        }
    }

    public Computer update(Computer computer) {
        if (computer.getId() != null) {
            Optional<Computer> consult = computerRepository.getComputer(computer.getId());
            if (!consult.isEmpty()) {
                if (computer.getName() != null) {
                    consult.get().setName(computer.getName());
                }
                if (computer.getDescription() != null) {
                    consult.get().setDescription(computer.getDescription());
                }
                if (computer.getBrand() != null) {
                    consult.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    consult.get().setYear(computer.getYear());
                }
                if (computer.getCategory() != null) {
                    consult.get().setCategory(computer.getCategory());
                }
                return computerRepository.save(consult.get());
            }
        }
        return computer;
    }

    public boolean deleteComputer(int id){
        Optional<Computer> consult = computerRepository.getComputer(id);
            if (!consult.isEmpty()) {
                computerRepository.delete(consult.get());
                return true;
            }
        return false;
    }
}
