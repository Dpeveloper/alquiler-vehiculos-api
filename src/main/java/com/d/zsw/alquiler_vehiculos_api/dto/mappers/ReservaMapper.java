package com.d.zsw.alquiler_vehiculos_api.dto.mappers;

import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    Reserva toReserva(ReservaDto reserva);

    ReservaDto toReservaDto(Reserva reserva);

    Reserva reservaToSaveDtoToReserva(ReservaToSaveDto reservaToSaveDto);
}
