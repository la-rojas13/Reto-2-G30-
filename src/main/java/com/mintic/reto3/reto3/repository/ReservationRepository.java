package com.mintic.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Reservation;
import com.mintic.reto3.reto3.repository.CRUD.ReservationCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrud reservationCrud;

    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrud.findAll();
    }

    public Optional<Reservation>getReservation(int id){
        return reservationCrud.findById(id);
    }
    
    public Reservation save(Reservation Reservation){
        return reservationCrud.save(Reservation);
    }

    public void delete(Reservation Reservation){
        reservationCrud.delete(Reservation);
    }
}
