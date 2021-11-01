package com.mintic.reto3.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Client;
import com.mintic.reto3.reto3.model.CountClient;
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
 
    public List<Reservation> reservationStatus(String status){
        return reservationCrud.findAllByStatus(status);
    }

    public List<Reservation> reservationByDate(Date a, Date b){
        return reservationCrud.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<CountClient> getClientRepository(){
        List <CountClient> res = new ArrayList<>();
        List <Object[]> report = reservationCrud.countTotalReservationsByClient();
        for(int i =0; i < report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1], (Client)report.get(i)[0]));
        }
        return res;
    }
}
