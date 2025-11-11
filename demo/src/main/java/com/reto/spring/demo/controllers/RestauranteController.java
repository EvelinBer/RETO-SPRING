package com.reto.spring.demo.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.RestauranteDto;
import com.reto.spring.demo.dtos.responses.RestauranteResponse;
import com.reto.spring.demo.services.interfaces.IRestauranteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
    private final IRestauranteService restauranteService;
    // como se que es este rol 
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @PostMapping("/crear")
    public String crearRestaurante (@RequestBody RestauranteDto restauranteDto) {
        String entity = restauranteService.crearRestaurante(restauranteDto);
        return entity;
    }
    @GetMapping("/listar")
public Page<RestauranteResponse> RestauranteResponseByAlphabeticOrder(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    
    Pageable pageable = PageRequest.of(page, size);
    return restauranteService.obtenerRestauranteAlfabetico(pageable);
}
    
}
