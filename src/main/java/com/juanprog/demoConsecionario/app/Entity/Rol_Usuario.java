package com.juanprog.demoConsecionario.app.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Rol_Usuarios")
@Data
public class Rol_Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "rol_usuario")
    String rol_usuario;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario fk_idUsuario;


}
