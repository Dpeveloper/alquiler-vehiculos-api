package com.d.zsw.alquiler_vehiculos_api.controller;

import com.d.zsw.alquiler_vehiculos_api.dto.CarroDto;
import com.d.zsw.alquiler_vehiculos_api.dto.CarroToSaveDto;
import com.d.zsw.alquiler_vehiculos_api.service.carro.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("reservas-vehiculos/v1/")
public class CarroController {
    private final CarroService carroService;
    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<CarroDto> addCarro(@RequestBody CarroToSaveDto carroToSaveDto) {
        return ResponseEntity.ok(carroService.save(carroToSaveDto));
    }
    @GetMapping("{id}")
    public ResponseEntity<List<CarroDto>> listarCarrosDisponibles(@RequestParam LocalDate inicio, @RequestParam LocalDate fin, @PathVariable("id") Long locacion) {
        List<CarroDto> carros = carroService.obtenerCarrosDisponibles(inicio, fin, locacion);
        return ResponseEntity.ok(carros);
    }
}
