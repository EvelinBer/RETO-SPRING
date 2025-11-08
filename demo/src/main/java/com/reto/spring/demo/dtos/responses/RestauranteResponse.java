package com.reto.spring.demo.dtos.responses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestauranteResponse {
    private String nombre;
    private String urlLogo;
}
