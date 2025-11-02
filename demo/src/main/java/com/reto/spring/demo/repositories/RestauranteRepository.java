package com.reto.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> { //trae la clase rol que esta conectada con la bd y trae un dato int

    Restaurante findByNombre(String nombre);
} 
