package com.reto.spring.demo.services.implementations;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.reto.spring.demo.dtos.RestauranteDto;
import com.reto.spring.demo.dtos.responses.RestauranteResponse;
import com.reto.spring.demo.entities.Restaurante;
import com.reto.spring.demo.entities.RolUsuario;
import com.reto.spring.demo.entities.Usuario;
import com.reto.spring.demo.repositories.RestauranteRepository;
import com.reto.spring.demo.repositories.RolUsuarioRepository;
import com.reto.spring.demo.repositories.UsuarioRepository;
import com.reto.spring.demo.services.interfaces.IRestauranteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // se utilizan para llamar los repositories o algun otro servicio
public class RestauranteService implements IRestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioRepository rolUsuarioRepository;
    @Override
    public String crearRestaurante (RestauranteDto restauranteDto) {
        // Validar teléfono: debe iniciar con + y contener 13 dígitos
        if (restauranteDto.getTelefono() == null || !restauranteDto.getTelefono().matches("^[+]\\d{13}$")) {
            return "El telefono debe iniciar por signo + y contener 13 digitos";
        }
        if (restauranteDto.getNit() == null || !restauranteDto.getNit().matches("^[0-9]+$")) {
            return "El NIT debe contener solo digitos numericos";
        }
        // Validar que el nombre no esté formado únicamente por números
        if (restauranteDto.getNombre().matches("^[0-9]+$")) {
            return "El nombre del restaurante no puede estar formado únicamente por números";
        }
        // Lógica para crear un restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteDto.getNombre());
        restaurante.setDireccion(restauranteDto.getDireccion());
        restaurante.setTelefono(restauranteDto.getTelefono());
        restaurante.setNit(restauranteDto.getNit());
        restaurante.setUrlLogo(restauranteDto.getUrlLogo());
        Usuario propietario = usuarioRepository.findById(restauranteDto.getPropietario()).orElse(null);
        if (propietario == null) {
            return "El propietario no existe";
        }
        List<RolUsuario> rolesUsuario = rolUsuarioRepository.findByUsuarioId(propietario);
        if (rolesUsuario.isEmpty()) {
            return "El usuario no existe";
        }
        RolUsuario rolUsuario = rolesUsuario.get(0);
        if(!rolUsuario.getRolId().getNombre().equals("PROPIETARIO")) {
            return "El usuario no es un propietario";
        }
        restaurante.setPropietario(propietario);
        restauranteRepository.save(restaurante);
        return "Restaurante creado exitosamente";
    }

   public Page<RestauranteResponse> obtenerRestauranteAlfabetico(Pageable pageable) {
    Page<Restaurante> restaurantes = restauranteRepository.findAllByOrderByNombreAsc(pageable);
    // porque hace esto ademas de contruir el objeto***********
    return restaurantes.map(restaurante -> RestauranteResponse.builder()
            .nombre(restaurante.getNombre())
            .urlLogo(restaurante.getUrlLogo())
            .build());
            //este metodo es para devolver la pagina con los restaurantes en orden alfabetico
}           // lo mapea a un objeto RestauranteResponse que es el que se va a devolver al cliente
}
