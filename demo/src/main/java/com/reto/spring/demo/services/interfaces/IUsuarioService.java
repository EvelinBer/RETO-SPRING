package com.reto.spring.demo.services.interfaces;
import com.reto.spring.demo.dtos.UsuarioDto;

public interface IUsuarioService {
    public String crearPropietario (UsuarioDto usuarioDto);
    public String crearEmpleado (UsuarioDto usuarioDto);
    public String crearCliente (UsuarioDto usuarioDto);
}
