package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import com.usergio.retos.retoapp.modelo.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll(){
        return repository.findAll();
    }
    public Reservation save(Reservation reservation){
        return repository.save(reservation);
    }
    public Optional<Reservation> getFindById(long id){
        return repository.findById(id);
    }
    public Reservation updateReservation(Reservation reservation){
        Optional<Reservation> reservationUpdate = getFindById(reservation.getIdReservation());
        if(reservationUpdate.isPresent()){
            reservationUpdate.get().setStartDate(reservation.getStartDate());
            reservationUpdate.get().setDevolutionDate(reservation.getDevolutionDate());
            reservationUpdate.get().setStatus(reservation.getStatus());
            reservationUpdate.get().setCar(reservation.getCar());
            reservationUpdate.get().setClient(reservation.getClient());
            return repository.save(reservationUpdate.get());
        }
        else{
            return reservation;
        }
    }
    public void deleteReservation(long id){
        repository.deleteById(id);
    }

}
