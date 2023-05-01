package com.juanprog.demoConsecionario.app.Servicio;

import com.juanprog.demoConsecionario.app.Entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculoServicio {
    public List<Vehiculo> encontrarTodos();
    public Vehiculo encontrarPorId(int id);

    public void actualizarVehiculo(Vehiculo vehiculo);

    public void crearVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculo(int id);
}
