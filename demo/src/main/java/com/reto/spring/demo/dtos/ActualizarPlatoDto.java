package com.reto.spring.demo.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ActualizarPlatoDto {
    private Integer id;
    private String descripcion;
    private Integer precio;
}