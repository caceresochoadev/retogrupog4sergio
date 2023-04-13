package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import com.usergio.retos.retoapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin("*")
public class ApiReservation {
    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return service.getAll();
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Reservation reservation){
        service.save(reservation);
        return ResponseEntity.status(201).build();
    }

}
