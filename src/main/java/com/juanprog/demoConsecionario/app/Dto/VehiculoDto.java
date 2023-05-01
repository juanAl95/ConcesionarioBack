package com.juanprog.demoConsecionario.app.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Data
@Component
public class VehiculoDto {
    private int id;
    private String precio;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
}
