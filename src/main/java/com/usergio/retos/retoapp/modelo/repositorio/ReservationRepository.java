package com.usergio.retos.retoapp.modelo.repositorio;

import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
