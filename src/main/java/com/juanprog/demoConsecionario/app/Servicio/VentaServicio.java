package com.juanprog.demoConsecionario.app.Servicio;

import com.juanprog.demoConsecionario.app.Entity.Venta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentaServicio {
    public List<Venta> encontrarTodos();

    public Venta encontrarPorId(int id);

    public void crearVenta(Venta venta);

    public void actualizarVenta(Venta venta);

    public void eliminarVenta(int id);
}
