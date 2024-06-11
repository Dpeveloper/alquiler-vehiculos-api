package com.d.zsw.alquiler_vehiculos_api.service.carro;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.CarroToSaveDto;

import java.time.LocalDate;
import java.util.List;

public interface CarroService {
    CarroDto save(CarroToSaveDto carroToSaveDto);
    List<CarroDto> obtenerCarrosDisponibles(LocalDate fin, Long locacion);
}
