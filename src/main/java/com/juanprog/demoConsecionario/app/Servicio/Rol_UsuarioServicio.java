package com.juanprog.demoConsecionario.app.Servicio;

import com.juanprog.demoConsecionario.app.Entity.Rol_Usuario;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface Rol_UsuarioServicio {
    public List<Rol_Usuario> encontrarTodos();
    public Rol_Usuario encontrarPorId(int id);

    public void actualizarRol_Usuario(Rol_Usuario rol_usuario);

    public void crearRol_Usuario(Rol_Usuario rol_usuario);

    public void eliminarRol_Usario(int id);


}
