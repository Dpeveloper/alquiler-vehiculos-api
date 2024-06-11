package com.d.zsw.alquiler_vehiculos_api.service.reserva;

import com.d.zsw.alquiler_vehiculos_api.dto.ReservaDto;
import com.d.zsw.alquiler_vehiculos_api.dto.ReservaToSaveDto;

public interface ReservaService {
    ReservaDto addReserva(ReservaToSaveDto reservaToSaveDto);
}
