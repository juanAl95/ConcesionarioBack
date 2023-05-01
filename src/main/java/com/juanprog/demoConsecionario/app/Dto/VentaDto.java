package com.juanprog.demoConsecionario.app.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class VentaDto {
    int id;
    Date fecha;
    int valor;
}
