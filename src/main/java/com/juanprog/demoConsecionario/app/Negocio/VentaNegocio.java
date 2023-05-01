package com.juanprog.demoConsecionario.app.Negocio;

import com.juanprog.demoConsecionario.app.Dto.UsuarioDto;
import com.juanprog.demoConsecionario.app.Dto.VentaDto;
import com.juanprog.demoConsecionario.app.Entity.Venta;
import com.juanprog.demoConsecionario.app.Implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    VentaImpl ventaImpl;

    private List<VentaDto> listVentaDto;

    public List<VentaDto> encontrarTodos(){
        listVentaDto = new ArrayList<>();

        this.ventaImpl.encontrarTodos().forEach(venta -> {

            VentaDto ventaDto = new VentaDto();
            ventaDto.setId(venta.getId());
            ventaDto.setFecha(venta.getFecha());
            ventaDto.setValor(venta.getValor());
            this.listVentaDto.add(ventaDto);
        });
        return this.listVentaDto;
    }

    public String guardarVentas(VentaDto ventaDto) {

        Venta venta = new Venta();

        try {
            if (ventaDto.getId() != 0) {
                venta.setId(ventaDto.getId());
                venta.setFecha(ventaDto.getFecha());
                venta.setValor(ventaDto.getValor());
                this.ventaImpl.actualizarVenta(venta);
            }else {
                venta.setId(ventaDto.getId());
                venta.setFecha(ventaDto.getFecha());
                venta.setValor(ventaDto.getValor());
                this.ventaImpl.crearVenta(venta);
            }
            return  "OK";
        }catch (Exception e) {
            return "BAD";
        }
    }


}
