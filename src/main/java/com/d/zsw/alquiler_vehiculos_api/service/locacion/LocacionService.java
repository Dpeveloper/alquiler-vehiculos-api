package com.d.zsw.alquiler_vehiculos_api.service.locacion;

import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;

import java.util.List;

public interface LocacionService {
    LocacionDto guardarLocacion(LocacionDto locacionDto);
    List<LocacionDto> cargarLocaciones();
}
