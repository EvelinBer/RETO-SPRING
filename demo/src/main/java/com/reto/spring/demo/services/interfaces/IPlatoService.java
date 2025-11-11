package com.reto.spring.demo.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.spring.demo.dtos.ActualizarPlatoDto;
import com.reto.spring.demo.dtos.PlatoDto;

public interface IPlatoService {
    public String crearPlato(PlatoDto platoDto); // esta linea viene de la clase PlatoService
    public String actualizarPlato(ActualizarPlatoDto actualizarPlatoDto);
    public String habilitarPlato(Integer id);
    public String deshabilitarPlato(Integer id);
    public Page<PlatoDto> obtenerPlatoCategoria(Pageable pageable, String categoria);
}