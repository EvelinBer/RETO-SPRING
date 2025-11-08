package com.reto.spring.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatoDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private Integer precio;
    private String categoria;
    private Integer restauranteId;
    private boolean activo;
}
