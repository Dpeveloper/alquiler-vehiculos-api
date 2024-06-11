package com.d.zsw.alquiler_vehiculos_api.service.carro;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.CarroMapper;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroServiceImp implements CarroService{

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;
    @Autowired
    public CarroServiceImp(CarroRepository carroRepository, CarroMapper carroMapper) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
    }

    @Override
    public CarroDto save(CarroDto carroDto) {
        return carroMapper.toCarroDto(carroRepository.save(carroMapper.toCarro(carroDto)));
    }

    @Override
    public List<CarroDto> obtenerCarrosDisponibles(LocalDate inicio, String locacion) {
        List<Carro> carros = carroRepository.findAll();

        List<Carro> carrosDisponibles = carros.stream()
                .filter(carro -> carro.getReservas().stream()
                        .noneMatch(reserva -> reserva.getFechaFin().isAfter(inicio) || reserva.getLocacion().equals(locacion)))
                .collect(Collectors.toList());

        return carrosDisponibles.stream()
                .map(carro -> carroMapper.toCarroDto(carro))
                .collect(Collectors.toList());
    }
}
