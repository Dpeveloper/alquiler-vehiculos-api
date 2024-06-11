package com.d.zsw.alquiler_vehiculos_api.controller;

import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;
import com.d.zsw.alquiler_vehiculos_api.service.locacion.LocacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservas-vehiculos/v1/locacion")
public class LocacionController {

    public final LocacionService locacionService;

    @Autowired
    public LocacionController(LocacionService locacionService) {
        this.locacionService = locacionService;
    }

    @PostMapping
    public LocacionDto addLocacion(@RequestBody LocacionDto locacionDto) {
        return locacionService.guardarLocacion(locacionDto);
    }

    @GetMapping
    public List<LocacionDto> getLocaciones(){
        return locacionService.cargarLocaciones();
    }
}
