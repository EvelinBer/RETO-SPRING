package com.reto.spring.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.ActualizarPlatoDto;
import com.reto.spring.demo.dtos.PlatoDto;
import com.reto.spring.demo.services.interfaces.IPlatoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plato")
@RequiredArgsConstructor
public class PlatoController {
    private final IPlatoService platoService;
    @PostMapping("/crear")
    public String crearPlato(@RequestBody PlatoDto platoDto) {
        return platoService.crearPlato(platoDto);
    }
    @PatchMapping("/actualizar")
    public String actualizarPlato(@RequestBody ActualizarPlatoDto actualizarPlatoDto) {
        return platoService.actualizarPlato(actualizarPlatoDto);
    }  
    @PreAuthorize("hasAuthority('PROPIETARIO')")
    @PatchMapping("/habilitar/{id}")
    public String habilitarPlato(@PathVariable Integer id) {
        return platoService.habilitarPlato(id);
    }
    @PreAuthorize("hasAuthority('PROPIETARIO')") // Indica que esta peticion solo puede ser ejecutada por usuarios con rol administrador
    @PatchMapping("/deshabilitar/{id}")
    public String deshabilitarPlato(@PathVariable Integer id) {
        return platoService.deshabilitarPlato(id);
    }
}
