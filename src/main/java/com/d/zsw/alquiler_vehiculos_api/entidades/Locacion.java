package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Locaciones")
public class Locacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombreLocacion;
    @OneToMany(mappedBy = "locacion")
    private List<Reserva> reserva;
}
