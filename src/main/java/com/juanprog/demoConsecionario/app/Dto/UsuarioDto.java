package com.juanprog.demoConsecionario.app.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UsuarioDto {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private int telefono;
    private String direccion;
}
