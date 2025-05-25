package com.d.zsw.alquiler_vehiculos_api.service.reserva;

import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.ReservaMapper;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
import com.d.zsw.alquiler_vehiculos_api.repository.CarroRepository;
import com.d.zsw.alquiler_vehiculos_api.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class ReservaServiceImp implements ReservaService{
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final CarroRepository carroRepository;

    @Autowired
    public ReservaServiceImp(ReservaRepository reservaRepository, ReservaMapper reservaMapper, CarroRepository carroRepository) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.carroRepository = carroRepository;
    }

    @Override
    @Transactional
    public ReservaDto addReserva(ReservaToSaveDto reservaToSaveDto) {
        Carro carro = carroRepository.findById(reservaToSaveDto.carroId())
                .orElseThrow(() -> new RuntimeException("Carro no encontrado"));

        LocalDate inicio = reservaToSaveDto.fechaInicio();
        LocalDate fin = reservaToSaveDto.fechaFin();

        if (fin.isBefore(inicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        boolean tieneConflictos = carro.getReservas().stream()
                .anyMatch(reserva ->
                        !reserva.getFechaFin().isBefore(inicio) &&
                                !reserva.getFechaInicio().isAfter(fin)
                );

        if (tieneConflictos) {
            throw new IllegalStateException("El carro ya está reservado en el rango de fechas seleccionado.");
        }

        long diasEntre = ChronoUnit.DAYS.between(inicio, fin) + 1;
        Reserva reserva = reservaMapper.reservaToSaveDtoToReserva(reservaToSaveDto);
        reserva.setValor(diasEntre * carro.getPrecio());
        reserva.setCarro(carro);

        return reservaMapper.toReservaDto(reservaRepository.save(reserva));
    }


}
