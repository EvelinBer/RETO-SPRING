package com.reto.spring.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    Restaurante findByNombre(String nombre);
     Page<Restaurante> findAllByOrderByNombreAsc(Pageable pageable);
    // Obtener todos los restaurantes ordenados por nombre de forma descendente
} 