package com.mintic.reto3.reto3.repository.CRUD;



import com.mintic.reto3.reto3.model.Reservation;

import org.springframework.data.repository.CrudRepository;

public interface ReservationCrud extends CrudRepository <Reservation,Integer> {
    
}
