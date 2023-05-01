package com.juanprog.demoConsecionario.app.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Data
@Component
public class Rol_UsuarioDto {
    private int id;
    private String rol_usuario;
}
