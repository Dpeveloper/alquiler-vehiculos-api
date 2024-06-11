package com.d.zsw.alquiler_vehiculos_api.dto.mappers;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.CarroToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarroMapper {
    default CarroDto toCarroDto(Carro carro){
        return  new CarroDto(carro.getId(),
                carro.getMarca(),
                carro.getMarca(),
                carro.getPlaca(),
                carro.getImagen(),
                carro.getPrecio(),
                carro.getLocacion().getNombre());
    };

    Carro carroToSaveDtoToCarro(CarroToSaveDto carroDto);
}
