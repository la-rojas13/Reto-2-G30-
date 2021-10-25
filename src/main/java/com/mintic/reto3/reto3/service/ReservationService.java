package com.mintic.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import com.mintic.reto3.reto3.model.Reservation;
import com.mintic.reto3.reto3.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> consult = reservationRepository.getReservation(reservation.getIdReservation());
            if (consult.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> consult = reservationRepository.getReservation(reservation.getIdReservation());
            if (!consult.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    consult.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    consult.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getClient() != null) {
                    consult.get().setClient(reservation.getClient());
                }
                if (reservation.getComputer() != null) {
                    consult.get().setComputer(reservation.getComputer());
                }
                if (reservation.getStatus() != null) {
                    consult.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(consult.get());
            }
        }
        return reservation;
    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> consult = reservationRepository.getReservation(id);
        if (!consult.isEmpty()) {
            reservationRepository.delete(consult.get());
            return true;
        }
        return false;
    }
}
