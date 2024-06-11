package com.d.zsw.alquiler_vehiculos_api.dto;

public record CarroToSaveDto(String marca, String modelo, String placa, String imagen, double precio, Long locacionId) {
}
