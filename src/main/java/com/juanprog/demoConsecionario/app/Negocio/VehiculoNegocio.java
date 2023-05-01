package com.juanprog.demoConsecionario.app.Negocio;


import com.juanprog.demoConsecionario.app.Dto.VehiculoDto;
import com.juanprog.demoConsecionario.app.Entity.Vehiculo;
import com.juanprog.demoConsecionario.app.Implementacion.VehiculoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {

    @Autowired
    private VehiculoImpl vehiculoImpl;

    private List<VehiculoDto> listDtoVehiculos;

    public List<VehiculoDto>encontrarTodos(){

        listDtoVehiculos = new ArrayList<>();

        this.vehiculoImpl.encontrarTodos().forEach(vehiculo ->{
            VehiculoDto vehiculoDto = new VehiculoDto();

            vehiculoDto.setId(vehiculo.getId());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            vehiculoDto.setPlaca(vehiculo.getPlaca());
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setModelo(vehiculo.getModelo());
            vehiculoDto.setColor(vehiculo.getColor());
            this.listDtoVehiculos.add(vehiculoDto);


        });
        return this.listDtoVehiculos;
    }
    public String guardarVehiculo(VehiculoDto vehiculoDto){

        Vehiculo vehiculo=new Vehiculo();

        try{
            if(vehiculoDto.getId()!=0){
                vehiculo.setPrecio(vehiculoDto.getPrecio());
                vehiculo.setPlaca(vehiculoDto.getPlaca());
                vehiculo.setMarca(vehiculoDto.getMarca());
                vehiculo.setModelo(vehiculoDto.getModelo());
                vehiculo.setColor(vehiculoDto.getColor());

                this.vehiculoImpl.actualizarVehiculo(vehiculo);

            }else{

                vehiculo.setPrecio(vehiculoDto.getPrecio());
                vehiculo.setPlaca(vehiculoDto.getPlaca());
                vehiculo.setMarca(vehiculoDto.getMarca());
                vehiculo.setModelo(vehiculoDto.getModelo());
                vehiculo.setColor(vehiculoDto.getColor());
                this.vehiculoImpl.crearVehiculo(vehiculo);
            }
            return "ok";
    }catch (Exception e){
            return "bad";
        }
    }
}
