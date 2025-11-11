package com.reto.spring.demo.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reto.spring.demo.dtos.RestauranteDto;
import com.reto.spring.demo.dtos.responses.RestauranteResponse;

public interface IRestauranteService {
 public String crearRestaurante (RestauranteDto restauranteDto);
 public Page<RestauranteResponse> obtenerRestauranteAlfabetico(Pageable pageable);
} 
