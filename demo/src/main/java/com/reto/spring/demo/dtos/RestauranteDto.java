package com.reto.spring.demo.dtos;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestauranteDto {
     private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;
    private String urlLogo;
    private Integer propietario; //buscamos el id del propietario para llamarlo al repo de usuario y miramos si eciste
    //y si existe lo traemos
}
