package com.reto.spring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity //Indicar que es una entidad de base de datos
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "fases") //Establecer el nombre de la tabla en la base de datos
public class Fases {

    @Id //Indicar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar que es llave primaria auto incremental
    private Integer id;
    private String nombre;
}