package com.juanprog.demoConsecionario.app.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Vehiculos")
@Data
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "precio")
    String precio;

    @Column(name= "placa")
    String placa;

    @Column(name = "marca")
    String marca;

    @Column (name  = "modelo")
    String modelo;

    @Column (name = "color")
    String color;

    @ManyToOne
    @JoinColumn (name = "venta_id")
    private Venta fk_idVenta;

    @ManyToOne
    @JoinColumn(name = "sede_consecionario_id")
    private Sede_Consecionario fk_idSede_Consecionario;



}
