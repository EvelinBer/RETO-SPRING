package com.reto.spring.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
@Entity //Indicar que es una entidad de base de datos
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "rol_usuario") //Establecer el nombre de la tabla en la base de datos
public class RolUsuario {
    @Id //Indicar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar que es llave primaria auto incremental
    private Integer id;
    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuarioId;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rolId;
}
