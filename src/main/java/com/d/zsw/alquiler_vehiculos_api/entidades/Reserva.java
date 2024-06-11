package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double valor;
    private PropietarioAlquiler propietarioAlquiler;
    @ManyToOne
    @JoinColumn(name = "carro_id",referencedColumnName = "id")
    private Carro carro;
}
