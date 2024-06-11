package com.d.zsw.alquiler_vehiculos_api.repository;

import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
