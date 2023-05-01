package com.juanprog.demoConsecionario.app.Implementacion;

import com.juanprog.demoConsecionario.app.Repositorio.RepositorySede_Consecionario;
import com.juanprog.demoConsecionario.app.Servicio.Sede_ConsecionarioServicio;
import com.juanprog.demoConsecionario.app.Entity.Sede_Consecionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sede_ConsecionarioImpl implements Sede_ConsecionarioServicio {

    @Autowired
    RepositorySede_Consecionario repositorySede_consecionario;

    @Override
    public List<Sede_Consecionario> encontrarTodos() {

      return this.repositorySede_consecionario.findAll();

    }

    @Override
    public Sede_Consecionario encontrarPorId(int id) {
        return this.repositorySede_consecionario.encontrarId(id);
    }

    @Override
    public void actualizarSede_Consecionario(Sede_Consecionario sede_consecionario) {

        this.repositorySede_consecionario.save(sede_consecionario);

    }

    @Override
    public void crearSede_Consecionario(Sede_Consecionario sede_consecionario) {

        this.repositorySede_consecionario.save(sede_consecionario);

    }

    @Override
    public void eliminarSede_Consecionario(int id) {
        Sede_Consecionario sede_consecionario=this.repositorySede_consecionario.encontrarId(id);
        if(sede_consecionario!=null){
            this.repositorySede_consecionario.delete(sede_consecionario);
        }

    }
}
