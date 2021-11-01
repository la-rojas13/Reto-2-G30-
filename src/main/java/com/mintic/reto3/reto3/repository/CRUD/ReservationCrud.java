package com.mintic.reto3.reto3.repository.CRUD;

import java.util.Date;
import java.util.List;

import com.mintic.reto3.reto3.model.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrud extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus(String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query("select c.client, COUNT(c.client) from Reservation as c group by c.client order by COUNT(c.client) desc")
    public List<Object[]>  countTotalReservationsByClient(); 

}
