package com.d.zsw.alquiler_vehiculos_api.dto.mappers;

import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;
import com.d.zsw.alquiler_vehiculos_api.dto.LocacionToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.entidades.Locacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocacionMapper {

    Locacion toLocacion(LocacionToSaveDto locacionToSaveDto);
    LocacionDto toLocacionDto(Locacion locacion);
}
