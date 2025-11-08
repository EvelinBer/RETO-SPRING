package com.reto.spring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plato {
    @Id // Indicar que es llave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Indicar que es llave primaria auto incremental
    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private Integer precio;
    private String categoria;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
