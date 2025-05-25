package com.d.zsw.alquiler_vehiculos_api.service.carro;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.CarroToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.CarroMapper;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
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
        return carroRepository.findAll().stream()
                .filter(carro -> esDeLocacion(carro, locacionId))
                .filter(carro -> estaDisponible(carro, inicio, fin))
                .map(carroMapper::toCarroDto)
                .collect(Collectors.toList());
    }

    private boolean esDeLocacion(Carro carro, Long locacionId) {
        return carro.getLocacion() != null && carro.getLocacion().getId().equals(locacionId);
    }

    private boolean estaDisponible(Carro carro, LocalDate inicio, LocalDate fin) {
        List<Reserva> reservas = carro.getReservas();
        if (reservas == null || reservas.isEmpty()) {
            return true;
        }

        return reservas.stream()
                .noneMatch(reserva -> fechasSeTraslapan(reserva.getFechaInicio(), reserva.getFechaFin(), inicio, fin));
    }

    private boolean fechasSeTraslapan(LocalDate reservaInicio, LocalDate reservaFin, LocalDate nuevaInicio, LocalDate nuevaFin) {
        return !reservaFin.isBefore(nuevaInicio) && !reservaInicio.isAfter(nuevaFin);
    }

}
