package com.reto.spring.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.UsuarioDto;
import com.reto.spring.demo.services.interfaces.IUsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor // se utilizan para llamar los servicios
@RestController // Indica que es un controlador de tipo REST
@RequestMapping("/usuario") // Indica que se mapean las rutas a este controlador

public class UsuarioController {

    private final IUsuarioService usuarioService;
    @PostMapping("/crear/propietario") // Indica que se mapean las rutas a este controlador
    public String crearPropietario(@RequestBody @Valid UsuarioDto usuarioDto) {
        String entity = usuarioService.crearPropietario(usuarioDto);
        return entity;
    }


}
