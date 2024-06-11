package com.d.zsw.alquiler_vehiculos_api.service.carro;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;

import java.time.LocalDate;
import java.util.List;

public interface CarroService {
    CarroDto save(CarroDto carroDto);
    List<CarroDto> obtenerCarrosDisponibles(LocalDate fin, String locacion);
}
