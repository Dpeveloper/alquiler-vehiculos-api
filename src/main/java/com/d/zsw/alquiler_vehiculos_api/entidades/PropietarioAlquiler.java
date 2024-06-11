package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class PropietarioAlquiler {
    private String nombrePropietarioAlquiler;
    private String apellidoPropietarioAlquiler;
    private String telefonoPropietarioAlquiler;
}
