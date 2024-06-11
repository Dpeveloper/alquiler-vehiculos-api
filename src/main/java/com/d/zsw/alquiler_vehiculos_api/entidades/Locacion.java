package com.d.zsw.alquiler_vehiculos_api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "locaciones")
public class Locacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;

    @OneToMany
    private List<Carro> carros;
}
