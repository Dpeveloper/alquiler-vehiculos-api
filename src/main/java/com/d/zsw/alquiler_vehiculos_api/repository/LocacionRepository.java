package com.d.zsw.alquiler_vehiculos_api.repository;

import com.d.zsw.alquiler_vehiculos_api.entidades.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacionRepository extends JpaRepository<Locacion, Long> {
}
