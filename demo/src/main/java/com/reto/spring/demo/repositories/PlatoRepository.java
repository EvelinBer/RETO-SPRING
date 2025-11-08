package com.reto.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Integer> { //trae la clase rol que esta conectada con la bd y trae un dato int

    Plato findByNombre(String nombre);
}