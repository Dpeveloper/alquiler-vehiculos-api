package com.d.zsw.alquiler_vehiculos_api.dto;

public record CarroDto(Long id, String marca, String modelo, String placa, String imagen, double precio, LocacionDto locacion) {
}
