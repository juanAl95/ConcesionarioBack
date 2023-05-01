package com.juanprog.demoConsecionario.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Sede_Consecionario")
@Data
public class Sede_Consecionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nombre_sede", length = 50)
    String nombre_sede;

    @Column (name = "direccion",length = 25)
    String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idSede_Consecionario")
    private List<Vehiculo> Listvehiculos;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idSede_Consecionario")
    private List<Venta> ListVentas;








}
