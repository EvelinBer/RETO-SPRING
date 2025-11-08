package com.reto.spring.demo.entities;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity //Indicar que es una entidad de base de datos
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Usuario {
    @Id //Indicar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicar que es llave primaria auto incremental
    private Integer id;
    private String nombre;
    private String apellido;
    @Pattern(regexp = "^[+]\\d{13}$", message = "El telefono debe iniciar por signo + y contener 13 digitos") 
    private String telefono;
    @Pattern (regexp = "^[0-9]+$", message = "El documento debe contener solo digitos numericos")
    private String documento;
    private LocalDate fechaNacimiento;
    @Email(message = "El correo no es valido")
    private String email;
    private String password;
}
