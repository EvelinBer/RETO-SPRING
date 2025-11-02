package com.reto.spring.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> { //trae la clase rol que esta conectada con la bd y trae un dato int

} //Carpeta para las interfaces que manejan la comunicacion con la base de datos