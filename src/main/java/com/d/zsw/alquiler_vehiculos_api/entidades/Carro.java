package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private String imagen;
    private double precio;

    @OneToMany(mappedBy = "carro", cascade = CascadeType.PERSIST)
    private List<Reserva> reservas;
}
