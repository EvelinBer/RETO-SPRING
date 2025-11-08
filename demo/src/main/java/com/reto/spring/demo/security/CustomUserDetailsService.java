package com.reto.spring.demo.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reto.spring.demo.entities.Usuario;
import com.reto.spring.demo.repositories.RolUsuarioRepository;
import com.reto.spring.demo.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioRepository rolUsuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
        
        List<String> roles = rolUsuarioRepository.findByUsuarioId(usuario)
                .stream()
                .map(rolUsuario -> rolUsuario.getRolId().getNombre())
                .collect(Collectors.toList());
        
        return UserPrincipal.build(usuario, roles);
    }
}
