package com.juanprog.demoConsecionario.app.Servicio;

import com.juanprog.demoConsecionario.app.Entity.Sede_Consecionario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface Sede_ConsecionarioServicio {

    public List<Sede_Consecionario> encontrarTodos();

    public Sede_Consecionario encontrarPorId(int id);

    public void actualizarSede_Consecionario(Sede_Consecionario sede_consecionario);

    public void crearSede_Consecionario(Sede_Consecionario sede_consecionario);

    public void eliminarSede_Consecionario(int id);
}
