package com.reto.spring.demo.services.implementations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reto.spring.demo.dtos.ActualizarPlatoDto;
import com.reto.spring.demo.dtos.PlatoDto;
import com.reto.spring.demo.entities.Plato;
import com.reto.spring.demo.entities.Restaurante;
import com.reto.spring.demo.repositories.PlatoRepository;
import com.reto.spring.demo.repositories.RestauranteRepository;
import com.reto.spring.demo.services.interfaces.IPlatoService;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor

public class PlatoService implements IPlatoService {
    private final PlatoRepository platoRepository;
    private final RestauranteRepository restauranteRepository;
    public String crearPlato(PlatoDto platoDto) {
        if (platoDto.getPrecio() == null || platoDto.getPrecio() <= 0) {
            return "El precio debe ser un número entero positivo mayor a 0";
        }

        Plato plato = new Plato();
        plato.setNombre(platoDto.getNombre());
        plato.setDescripcion(platoDto.getDescripcion());
        plato.setUrlImagen(platoDto.getUrlImagen());
        plato.setPrecio(platoDto.getPrecio());
        plato.setCategoria(platoDto.getCategoria());
        plato.setActivo(true);
        Restaurante restaurante = restauranteRepository.findById(platoDto.getRestauranteId()).orElse(null);
        if (restaurante == null) {
            return "El restaurante no existe";
        }
        plato.setRestaurante(restaurante);
        platoRepository.save(plato);
        return "Plato creado exitosamente";
    }

public String actualizarPlato(ActualizarPlatoDto actualizarPlatoDto) {
    Plato plato = platoRepository.findById(actualizarPlatoDto.getId()).orElse(null);
    if (plato == null) {
        return "El plato no existe";
    }
    plato.setDescripcion(actualizarPlatoDto.getDescripcion());
     if (actualizarPlatoDto.getPrecio() == null || actualizarPlatoDto.getPrecio() <= 0) {
            return "El precio debe ser un número entero positivo mayor a 0";
        }
    plato.setPrecio(actualizarPlatoDto.getPrecio());
    platoRepository.save(plato);
    return "Plato actualizado exitosamente";
}
public String habilitarPlato(Integer id) {
    Plato plato = platoRepository.findById(id).orElse(null);
    if (plato == null) {
        return "El plato no existe";
    }
    plato.setActivo(true);
    platoRepository.save(plato);
    return "Plato habilitado exitosamente";
}
public String deshabilitarPlato(Integer id) {   
    Plato plato = platoRepository.findById(id).orElse(null);
    if (plato == null) {
        return "El plato no existe";
    }
    plato.setActivo(false);
    platoRepository.save(plato);
    return "Plato deshabilitado exitosamente";    
}
public Page<PlatoDto> obtenerPlatoCategoria(Pageable pageable, String categoria) {
    Page<Plato> platos = platoRepository.findByCategoria(categoria, pageable);

    return platos.map(plato -> {
        PlatoDto platoDto = new PlatoDto();
        platoDto.setId(plato.getId());
        platoDto.setNombre(plato.getNombre());
        platoDto.setDescripcion(plato.getDescripcion());
        platoDto.setUrlImagen(plato.getUrlImagen());
        platoDto.setPrecio(plato.getPrecio());
        platoDto.setCategoria(plato.getCategoria());
        platoDto.setRestauranteId(plato.getRestaurante().getId());
        return platoDto;
    });

}
}
