package com.d.zsw.alquiler_vehiculos_api.service.carro;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.CarroToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.CarroMapper;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.repository.CarroRepository;
import com.d.zsw.alquiler_vehiculos_api.repository.LocacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroServiceImp implements CarroService{

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;
    private final LocacionRepository locacionRepository;
    @Autowired
    public CarroServiceImp(CarroRepository carroRepository, CarroMapper carroMapper, LocacionRepository locacionRepository) {
        this.carroRepository = carroRepository;
        this.carroMapper = carroMapper;
        this.locacionRepository = locacionRepository;
    }

    @Override
    public CarroDto save(CarroToSaveDto carroToSaveDto) {
        Carro carro = carroMapper.carroToSaveDtoToCarro(carroToSaveDto);
        carro.setLocacion(locacionRepository.findById(carroToSaveDto.locacionId())
                .orElseThrow(()->new RuntimeException("No se encontro locacion")));

        return carroMapper.toCarroDto(carroRepository.save(carro));
    }

    @Override
    public List<CarroDto> obtenerCarrosDisponibles(LocalDate inicio, LocalDate fin, Long locacionId) {
        List<Carro> carros = carroRepository.findAll();

        List<Carro> carrosDisponibles = carros.stream()
                .filter(carro -> carro.getLocacion().getId().equals(locacionId)) // Filtra por locación
                .filter(carro -> carro.getReservas().stream()
                        .noneMatch(reserva -> reserva.getFechaFin().isAfter(inicio) && reserva.getFechaInicio().isBefore(fin.minusDays(1)))) // Filtra por disponibilidad
                .collect(Collectors.toList());

        return carrosDisponibles.stream()
                .map(carro -> carroMapper.toCarroDto(carro))
                .collect(Collectors.toList());
    }
}
