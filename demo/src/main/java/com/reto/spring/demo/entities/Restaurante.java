package com.reto.spring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "restaurante") //Establecer el nombre de la tabla en la base de datos
public class Restaurante {
    @Id //Indicar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar que es llave primaria auto incremental
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;
    private String urlLogo;
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Usuario propietario;
}
