package com.reto.spring.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.RestauranteDto;
import com.reto.spring.demo.services.interfaces.IRestauranteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor // se utilizan para llamar los servicios
@RestController // Indica que es un controlador de tipo REST
@RequestMapping("/restaurante") // Indica que se mapean las rutas a este controlador
public class RestauranteController {
    private final IRestauranteService restauranteService;
    @PostMapping("/crear")
    public String crearRestaurante (@RequestBody RestauranteDto restauranteDto) {
        String entity = restauranteService.crearRestaurante(restauranteDto);
        return entity;
    }
    
}
