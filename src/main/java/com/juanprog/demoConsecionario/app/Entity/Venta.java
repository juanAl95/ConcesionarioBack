package com.juanprog.demoConsecionario.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Ventas")
@Data
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    Date fecha;

    @Column (name = "valor")
    int valor;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    Usuario fk_idUsuario;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idVenta")
    private List<Vehiculo> ListVehiculos;

    @ManyToOne
    @JoinColumn(name= "Sede_consecionario_id")
    Sede_Consecionario fk_idSede_Consecionario;
}
