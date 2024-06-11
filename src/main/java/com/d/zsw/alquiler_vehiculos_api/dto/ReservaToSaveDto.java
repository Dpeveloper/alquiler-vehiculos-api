package com.d.zsw.alquiler_vehiculos_api.dto;

import com.d.zsw.alquiler_vehiculos_api.entidades.PropietarioAlquiler;

import java.time.LocalDate;

public record ReservaToSaveDto(LocalDate fechaInicio, LocalDate fechaFin, double valor, PropietarioAlquiler propietarioAlquiler, Long carroId) {
}
