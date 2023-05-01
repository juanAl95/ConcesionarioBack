package com.juanprog.demoConsecionario.app.Dto;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Sede_ConsecionarioDto {
    private int Id;
    private String nombre_sede;
    private String direccion;
}
