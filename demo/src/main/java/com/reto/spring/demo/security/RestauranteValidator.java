package com.reto.spring.demo.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import com.reto.spring.demo.entities.Restaurante;
import com.reto.spring.demo.repositories.RestauranteRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RestauranteValidator {
    
    private final RestauranteRepository restauranteRepository;
    
    public void validarPropietarioDelRestaurante(Integer restauranteId) {
        Integer usuarioActualId = SecurityUtils.getCurrentUserId();
        
        if (usuarioActualId == null) {
            throw new AccessDeniedException("Usuario no autenticado");
        }
        
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante no encontrado con ID: " + restauranteId));
        
        if (!restaurante.getPropietario().getId().equals(usuarioActualId)) {
            throw new AccessDeniedException("No tienes permisos para modificar este restaurante. Solo el propietario puede realizar esta acción.");
        }
    }
    
    public boolean esPropietarioDelRestaurante(Integer restauranteId, Integer usuarioId) {
        if (restauranteId == null || usuarioId == null) {
            return false;
        }
        
        return restauranteRepository.findById(restauranteId)
                .map(restaurante -> restaurante.getPropietario().getId().equals(usuarioId))
                .orElse(false);
    }
}
