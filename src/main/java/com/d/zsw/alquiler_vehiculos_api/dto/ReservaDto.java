package com.d.zsw.alquiler_vehiculos_api.dto;

import com.d.zsw.alquiler_vehiculos_api.entidades.PropietarioAlquiler;

import java.time.LocalDate;

public record ReservaDto(Long id, LocalDate fechaInicio, LocalDate fechaFin, double valor, PropietarioAlquiler propietarioAlquiler, CarroDto carro) {
}
