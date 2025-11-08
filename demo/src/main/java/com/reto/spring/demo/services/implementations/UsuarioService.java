package com.reto.spring.demo.services.implementations;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDate;
import java.time.Period;

import com.reto.spring.demo.dtos.UsuarioDto;
import com.reto.spring.demo.entities.Rol;
import com.reto.spring.demo.entities.RolUsuario;
import com.reto.spring.demo.entities.Usuario;
import com.reto.spring.demo.repositories.RolRepository;
import com.reto.spring.demo.repositories.RolUsuarioRepository;
import com.reto.spring.demo.repositories.UsuarioRepository;
import com.reto.spring.demo.services.interfaces.IUsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // se utilizan para llamar los repositories o algun otro servicio
@Service // Indica que es un servicio que contiene la logica del negocio
public class UsuarioService implements IUsuarioService{
    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioRepository rolUsuarioService;
    private final RolRepository rolRepository;
     private final PasswordEncoder passwordEncoder; // Aquí inyectamos el encoder
    @Override
    public String crearPropietario (UsuarioDto usuarioDto) {
        // Validar teléfono: debe iniciar con + y contener 13 dígitos
        if (usuarioDto.getTelefono() == null || !usuarioDto.getTelefono().matches("^[+]\\d{13}$")) {
            return "El telefono debe iniciar por signo + y contener 13 digitos";
        }

        // Validar documento: solo dígitos numéricos
        if (usuarioDto.getDocumento() == null || !usuarioDto.getDocumento().matches("^[0-9]+$")) {
            return "El documento debe contener solo digitos numericos";
        }

        // Validar email
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (usuarioDto.getEmail() == null || !usuarioDto.getEmail().matches(emailRegex)) {
            return "El correo no es valido";
        }

        // Validar fecha de nacimiento: el propietario debe ser mayor o igual a 18 años
        LocalDate fechaNacimiento = usuarioDto.getFechaNacimiento();
        if (fechaNacimiento == null) {
            return "La fecha de nacimiento es requerida";
        }
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 18) {
            return "El propietario debe ser mayor de edad (18 años o más)";
        }

        // Validar que los campos requeridos no sean null o vacíos
        if (usuarioDto.getNombre() == null || usuarioDto.getNombre().trim().isEmpty()) {
            return "El nombre es requerido";
        }
        if (usuarioDto.getApellido() == null || usuarioDto.getApellido().trim().isEmpty()) {
            return "El apellido es requerido";
        }
        if (usuarioDto.getPassword() == null || usuarioDto.getPassword().trim().isEmpty()) {
            return "La contraseña es requerida";
        }

        Rol rol = rolRepository.findByNombre("PROPIETARIO");
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setDocumento(usuarioDto.getDocumento());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuario.setEmail(usuarioDto.getEmail());
        String passwordEncriptada = passwordEncoder.encode(usuarioDto.getPassword());
        usuario.setPassword(passwordEncriptada);
        usuarioRepository.save(usuario);
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setRolId(rol);
        rolUsuario.setUsuarioId(usuario);
        rolUsuarioService.save(rolUsuario);
        
        return "Propietario creado exitosamente";
    }
    
    @Override
    public String crearEmpleado(UsuarioDto usuarioDto) {
        if (usuarioDto.getTelefono() == null || !usuarioDto.getTelefono().matches("^[+]\\d{13}$")) {
            return "El telefono debe iniciar por signo + y contener 13 digitos";
        }

        if (usuarioDto.getDocumento() == null || !usuarioDto.getDocumento().matches("^[0-9]+$")) {
            return "El documento debe contener solo digitos numericos";
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (usuarioDto.getEmail() == null || !usuarioDto.getEmail().matches(emailRegex)) {
            return "El correo no es valido";
        }

        LocalDate fechaNacimiento = usuarioDto.getFechaNacimiento();
        if (fechaNacimiento == null) {
            return "La fecha de nacimiento es requerida";
        }
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 18) {
            return "El empleado debe ser mayor de edad (18 años o más)";
        }

        if (usuarioDto.getNombre() == null || usuarioDto.getNombre().trim().isEmpty()) {
            return "El nombre es requerido";
        }
        if (usuarioDto.getApellido() == null || usuarioDto.getApellido().trim().isEmpty()) {
            return "El apellido es requerido";
        }
        if (usuarioDto.getPassword() == null || usuarioDto.getPassword().trim().isEmpty()) {
            return "La contraseña es requerida";
        }

        Rol rol = rolRepository.findByNombre("EMPLEADO");
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setDocumento(usuarioDto.getDocumento());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuario.setEmail(usuarioDto.getEmail());
        String passwordEncriptada = passwordEncoder.encode(usuarioDto.getPassword());
        usuario.setPassword(passwordEncriptada);
        usuarioRepository.save(usuario);
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setRolId(rol);
        rolUsuario.setUsuarioId(usuario);
        rolUsuarioService.save(rolUsuario);
        
        return "Empleado creado exitosamente";
    }   
    @Override
    public String crearCliente (UsuarioDto usuarioDto) {
        if (usuarioDto.getTelefono() == null || !usuarioDto.getTelefono().matches("^[+]\\d{13}$")) {
            return "El telefono debe iniciar por signo + y contener 13 digitos";
        }

        if (usuarioDto.getDocumento() == null || !usuarioDto.getDocumento().matches("^[0-9]+$")) {
            return "El documento debe contener solo digitos numericos";
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (usuarioDto.getEmail() == null || !usuarioDto.getEmail().matches(emailRegex)) {
            return "El correo no es valido";
        }
        if (usuarioDto.getNombre() == null || usuarioDto.getNombre().trim().isEmpty()) {
            return "El nombre es requerido";
        }
        if (usuarioDto.getApellido() == null || usuarioDto.getApellido().trim().isEmpty()) {
            return "El apellido es requerido";
        }
        if (usuarioDto.getPassword() == null || usuarioDto.getPassword().trim().isEmpty()) {
            return "La contraseña es requerida";
        }

        Rol rol = rolRepository.findByNombre("CLIENTE");
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setDocumento(usuarioDto.getDocumento());
        usuario.setEmail(usuarioDto.getEmail());
        String passwordEncriptada = passwordEncoder.encode(usuarioDto.getPassword());
        usuario.setPassword(passwordEncriptada);
        usuarioRepository.save(usuario);
        RolUsuario rolUsuario = new RolUsuario();
        rolUsuario.setRolId(rol);
        rolUsuario.setUsuarioId(usuario);
        rolUsuarioService.save(rolUsuario);
        
        return "Cliente creado exitosamente";
    }
    
}
