package com.d.zsw.alquiler_vehiculos_api.service.locacion;

import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;
import com.d.zsw.alquiler_vehiculos_api.dto.LocacionToSaveDto;

import java.util.List;

public interface LocacionService {
    LocacionDto guardarLocacion(LocacionToSaveDto locacionToSaveDto);
    List<LocacionDto> cargarLocaciones();
}
