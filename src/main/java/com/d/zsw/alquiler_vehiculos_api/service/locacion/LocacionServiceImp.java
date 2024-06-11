package com.d.zsw.alquiler_vehiculos_api.service.locacion;

import com.d.zsw.alquiler_vehiculos_api.dto.LocacionDto;
import com.d.zsw.alquiler_vehiculos_api.dto.mappers.LocacionMapper;
import com.d.zsw.alquiler_vehiculos_api.repository.LocacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacionServiceImp implements LocacionService{

    private final LocacionRepository locacionRepository;
    private final LocacionMapper locacionMapper;

    @Autowired
    public LocacionServiceImp(LocacionRepository locacionRepository, LocacionMapper locacionMapper) {
        this.locacionRepository = locacionRepository;
        this.locacionMapper = locacionMapper;
    }

    @Override
    public LocacionDto guardarLocacion(LocacionDto locacionDto) {
        return locacionMapper.toLocacionDto(locacionRepository.save(locacionMapper.toLocacion(locacionDto)));
    }

    @Override
    public List<LocacionDto> cargarLocaciones() {
        return locacionRepository.findAll().stream()
                .map(locacionMapper::toLocacionDto).toList();
    }
}
