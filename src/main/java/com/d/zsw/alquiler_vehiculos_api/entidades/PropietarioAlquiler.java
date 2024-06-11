package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioAlquiler {
    private String nombrePropietarioAlquiler;
    private String apellidoPropietarioAlquiler;
    private String telefonoPropietarioAlquiler;
}
