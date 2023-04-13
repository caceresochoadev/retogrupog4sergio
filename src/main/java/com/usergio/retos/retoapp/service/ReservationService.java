package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import com.usergio.retos.retoapp.modelo.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
