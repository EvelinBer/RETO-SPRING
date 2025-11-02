package com.reto.spring.demo.dtos;
import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
        
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
