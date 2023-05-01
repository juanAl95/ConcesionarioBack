package com.juanprog.demoConsecionario.app.Implementacion;

import com.juanprog.demoConsecionario.app.Repositorio.RepositoryVehiculo;
import com.juanprog.demoConsecionario.app.Servicio.VehiculoServicio;
import com.juanprog.demoConsecionario.app.Entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {

   @Autowired
    RepositoryVehiculo repositoryVehiculo;
    @Override
    public List<Vehiculo> encontrarTodos() {

        return this.repositoryVehiculo.findAll();

    }

    @Override
    public Vehiculo encontrarPorId(int id) {

        return this.repositoryVehiculo.encontrar(id);

    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {

         this.repositoryVehiculo.save(vehiculo);


    }

    @Override

    public void crearVehiculo(Vehiculo vehiculo) {

        this.repositoryVehiculo.save(vehiculo);

    }

    @Override
    public void eliminarVehiculo(int id) {
        Vehiculo vehiculo=this.repositoryVehiculo.encontrar(id);
        if (vehiculo!=null){
            this.repositoryVehiculo.delete(vehiculo);
        }

    }
}
