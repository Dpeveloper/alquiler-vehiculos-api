package com.d.zsw.alquiler_vehiculos_api.service.reserva;

import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.ReservaMapper;
import com.d.zsw.alquiler_vehiculos_api.entidades.Carro;
import com.d.zsw.alquiler_vehiculos_api.entidades.Reserva;
import com.d.zsw.alquiler_vehiculos_api.repository.CarroRepository;
import com.d.zsw.alquiler_vehiculos_api.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;

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
    public ReservaDto addReserva(ReservaToSaveDto reservaToSaveDto) {
        Carro carro = carroRepository.findById(reservaToSaveDto.carroId())
                .orElseThrow(() -> new RuntimeException("Carro no encontrado"));

        Reserva reserva1 = reservaMapper.reservaToSaveDtoToReserva(reservaToSaveDto);

        Period periodo = Period.between(reservaToSaveDto.fechaInicio(), reservaToSaveDto.fechaFin());
        int diasEntrePeriod = periodo.getDays();

        reserva1.setValor(diasEntrePeriod * carro.getPrecio());
        reserva1.setCarro(carro);
        return reservaMapper.toReservaDto(reservaRepository.save(reserva1));
    }
}
