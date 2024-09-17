package com.example.plantapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data //toString, equals, hashcode, getters y setters
@NoArgsConstructor
@AllArgsConstructor
public class Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String especie;

    private String colorHojas;

    private LocalDate fechaPlantacion;

    @ManyToOne
    @JoinColumn(name = "jardinero_id") // *nombre de la tabla*_*columna*, por el motor de bd h2
    @ToString.Exclude //solución loop infinito lombok
    private Jardinero jardinero;

    @ManyToMany
    @JoinTable(
            name = "planta_prospecto",
            joinColumns = @JoinColumn(name = "planta_id"),
            inverseJoinColumns = @JoinColumn(name = "prospecto_id")
    )
    private List<Prospecto> prospectosAsociados;
}