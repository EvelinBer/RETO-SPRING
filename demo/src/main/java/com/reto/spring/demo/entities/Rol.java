package com.reto.spring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Indicar que es una entidad de base de datos
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor 
@Table(name = "rol") //Establecer el nombre de la tabla en la base de datos

public class Rol {

    @Id //Indicar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar que es llave primaria auto incremental
    private Integer id;
    private String nombre;
}

