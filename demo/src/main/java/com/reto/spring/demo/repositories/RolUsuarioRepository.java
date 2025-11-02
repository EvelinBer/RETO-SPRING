package com.reto.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.RolUsuario;
import com.reto.spring.demo.entities.Usuario;
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Integer> { //trae la clase rol que esta conectada con la bd y trae un dato int
    List<RolUsuario> findByUsuarioId(Usuario usuarioId);
} //Carpeta para las interfaces que manejan la comunicacion con la base de datos
