package com.juanprog.demoConsecionario.app.Servicio;

import com.juanprog.demoConsecionario.app.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UsuarioServicio {

    public List<Usuario> encontrarTodos();
    public Usuario encontrarPorId(int id);

    public void actualizarUsuario(Usuario usuario);

    public void crearUsuario(Usuario usuario);

    public void eliminarUsario(int id);

}


