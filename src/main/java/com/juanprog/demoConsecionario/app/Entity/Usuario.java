package com.juanprog.demoConsecionario.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50)
    String nombre;

    @Column(name = "apellido", length = 50)
    String apellido;

    @Column(name = "correo", length = 50)
    String correo;

    @Column(name = "edad", length = 10)
    int eaad;

    @Column(name = "telefono", length = 15)
    int telefono;

    @Column (name = "direccion", length = 50)
    String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idUsuario")
    private List<Venta> listVentas;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idUsuario")
    private List<Rol_Usuario> ListRolUsuarios;








}
