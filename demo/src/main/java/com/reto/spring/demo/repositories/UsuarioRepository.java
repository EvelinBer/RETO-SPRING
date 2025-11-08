package com.reto.spring.demo.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.spring.demo.entities.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}