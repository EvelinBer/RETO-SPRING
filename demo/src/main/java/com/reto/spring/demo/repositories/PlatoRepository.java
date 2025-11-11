package com.reto.spring.demo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Integer> { //trae la clase rol que esta conectada con la bd y trae un dato int

    Plato findByNombre(String nombre);
    // lista las categorias de los platos
    Page<Plato> findByCategoria(String categoria, Pageable pageable);
}
