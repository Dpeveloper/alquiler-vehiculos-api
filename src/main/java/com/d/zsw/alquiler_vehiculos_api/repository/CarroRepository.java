package com.d.zsw.alquiler_vehiculos_api.repository;

import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findAll();
}
