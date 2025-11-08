package com.reto.spring.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.spring.demo.dtos.UsuarioDto;
import com.reto.spring.demo.services.interfaces.IUsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;
    
    @PreAuthorize("hasAuthority('ADMINISTRADOR')") // Indica que esta peticion solo puede ser ejecutada por usuarios con rol administrador 
    @PostMapping("/crear/propietario")
    public String crearPropietario(@RequestBody @Valid UsuarioDto usuarioDto) {
        String entity = usuarioService.crearPropietario(usuarioDto);
        return entity;
    }
    
    @PreAuthorize("hasAuthority('PROPIETARIO')")
    @PostMapping("/crear/empleado")
    public String crearEmpleado(@RequestBody @Valid UsuarioDto usuarioDto) {
        String entity = usuarioService.crearEmpleado(usuarioDto);
        return entity;
    }

    @PostMapping("/crear/cliente")
    public String crearCliente(@RequestBody @Valid UsuarioDto usuarioDto) {
        String entity = usuarioService.crearCliente(usuarioDto);
        return entity;
    }
}
