package com.juanprog.demoConsecionario.app.Negocio;

import com.juanprog.demoConsecionario.app.Dto.Sede_ConsecionarioDto;
import com.juanprog.demoConsecionario.app.Entity.Sede_Consecionario;
import com.juanprog.demoConsecionario.app.Implementacion.Sede_ConsecionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Sede_ConsecionarioNegocio {

    @Autowired
    private Sede_ConsecionarioImpl sede_consecionarioimpl;
    private List<Sede_ConsecionarioDto>listDtoSede_Consecionarios;

    public List<Sede_ConsecionarioDto>encontrarTodos(){

        listDtoSede_Consecionarios =new ArrayList<>();

        this.sede_consecionarioimpl.encontrarTodos().forEach(concesionario->{
            Sede_ConsecionarioDto sede_consecionarioDto= new Sede_ConsecionarioDto();
            sede_consecionarioDto.setId(concesionario.getId());
            sede_consecionarioDto.setNombre_sede(concesionario.getNombre_sede());
            sede_consecionarioDto.setDireccion(concesionario.getDireccion());
            this.listDtoSede_Consecionarios.add(sede_consecionarioDto);
        });
        return this.listDtoSede_Consecionarios;
    }

    public String guardarSede_Consecionario(Sede_ConsecionarioDto sede_consecionarioDto){
        Sede_Consecionario sede_consecionario=new Sede_Consecionario();
        try {
            if (sede_consecionario.getId()!=0){
                sede_consecionario.setId(sede_consecionarioDto.getId());
                sede_consecionario.setNombre_sede(sede_consecionarioDto.getNombre_sede());
                sede_consecionario.setDireccion(sede_consecionarioDto.getDireccion());
                this.sede_consecionarioimpl.actualizarSede_Consecionario(sede_consecionario);

            }else {
                    sede_consecionario.setId(sede_consecionarioDto.getId());
                    sede_consecionario.setNombre_sede(sede_consecionarioDto.getNombre_sede());
                    sede_consecionario.setDireccion(sede_consecionarioDto.getDireccion());
                    this.sede_consecionarioimpl.crearSede_Consecionario(sede_consecionario);
            }
            return"ok";
        }catch(Exception e){
            return"bad";
        }
    }
}
