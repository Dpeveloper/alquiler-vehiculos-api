package com.d.zsw.alquiler_vehiculos_api.controller;

import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.service.reserva.ReservaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservas-vehiculos/v1/Reservar")
public class ReservaController {

    private final ReservaServiceImp reservaService;
    @Autowired
    public ReservaController(ReservaServiceImp reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaDto> reservar(@RequestBody ReservaToSaveDto reservaToSaveDto) {
        ReservaDto reservaDto1 = reservaService.addReserva(reservaToSaveDto);
        return ResponseEntity.ok(reservaDto1);
    }
}
