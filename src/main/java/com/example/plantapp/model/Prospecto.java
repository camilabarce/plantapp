package com.example.plantapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prospecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre; //tierra, fertilizante, agua, etc.

    private Double cantidad;

    private String unidad; //kg, lts, etc

    @ManyToMany(mappedBy = "prospectosAsociados", fetch = FetchType.EAGER)
    private List<Planta> plantas;
}
