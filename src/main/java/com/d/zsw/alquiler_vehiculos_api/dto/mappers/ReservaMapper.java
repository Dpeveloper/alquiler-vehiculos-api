package com.d.zsw.alquiler_vehiculos_api.dto.mappers;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.entidades.PropietarioAlquiler;
import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    default ReservaDto toReservaDto(Reserva reserva){
        PropietarioAlquiler propietarioAlquiler =
                new PropietarioAlquiler(reserva.getPropietarioAlquiler().getNombrePropietarioAlquiler(),
                        reserva.getPropietarioAlquiler().getApellidoPropietarioAlquiler(),
                        reserva.getPropietarioAlquiler().getTelefonoPropietarioAlquiler());
        Carro carro = reserva.getCarro();

        CarroDto carroDto = new CarroDto(carro.getId(), carro.getMarca(),carro.getModelo(), carro.getPlaca(), carro.getImagen(), carro.getPrecio(),carro.getLocacion().getNombre());
        return new ReservaDto(reserva.getId(),
             reserva.getFechaInicio(),
             reserva.getFechaFin(),
             reserva.getValor(),
             propietarioAlquiler,
            reserva.getCarro().getLocacion().getNombre().toString(),
                carroDto);
    }

    Reserva reservaToSaveDtoToReserva(ReservaToSaveDto reservaToSaveDto);
}
