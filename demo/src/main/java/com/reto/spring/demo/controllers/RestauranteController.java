package com.reto.spring.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.RestauranteDto;
import com.reto.spring.demo.services.interfaces.IRestauranteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    private final IRestauranteService restauranteService;
    
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping("/crear")
    public String crearRestaurante (@RequestBody RestauranteDto restauranteDto) {
        String entity = restauranteService.crearRestaurante(restauranteDto);
        return entity;
    }
}
