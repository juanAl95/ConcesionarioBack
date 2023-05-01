package com.juanprog.demoConsecionario.app.Implementacion;

import com.juanprog.demoConsecionario.app.Repositorio.RepositoryVenta;
import com.juanprog.demoConsecionario.app.Servicio.VentaServicio;
import com.juanprog.demoConsecionario.app.Entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {

    @Autowired
    RepositoryVenta repositoryVenta;


    @Override
    public List<Venta> encontrarTodos() {
        return this.repositoryVenta.findAll();
    }

    @Override
    public Venta encontrarPorId(int id) {
        return this.repositoryVenta.encontrarId(id);
    }

    @Override
    public void crearVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void eliminarVenta(int id) {
        Venta venta=this.repositoryVenta.encontrarId(id);
        if(venta!=null){
            this.repositoryVenta.delete(venta);
        }
    }
}
