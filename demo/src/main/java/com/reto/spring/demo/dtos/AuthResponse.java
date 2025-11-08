package com.reto.spring.demo.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    
    private String token;
    @Builder.Default
    private String type = "Bearer";
    private Integer id;
    private String email;
    private String nombre;
    private List<String> roles;
    
    public AuthResponse(String token, Integer id, String email, String nombre, List<String> roles) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.roles = roles;
    }
}
