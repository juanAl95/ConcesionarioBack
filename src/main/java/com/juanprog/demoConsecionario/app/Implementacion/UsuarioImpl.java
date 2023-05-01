package com.juanprog.demoConsecionario.app.Implementacion;

import com.juanprog.demoConsecionario.app.Repositorio.RepositoryUsuario;
import com.juanprog.demoConsecionario.app.Servicio.UsuarioServicio;
import com.juanprog.demoConsecionario.app.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioImpl implements UsuarioServicio {

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    public List<Usuario> encontrarTodos() {

        return this.repositoryUsuario.findAll();

    }

    @Override
    public Usuario encontrarPorId(int id) {

        return this.repositoryUsuario.encontrarId(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {

         this.repositoryUsuario.save(usuario);

    }

    @Override
    public void crearUsuario(Usuario usuario) {

        this.repositoryUsuario.save(usuario);
    }

    @Override
    public void eliminarUsario(int id) {
        Usuario usuario=this.repositoryUsuario.encontrarId(id);
        if(usuario!=null){
            this.repositoryUsuario.delete(usuario);
        }

    }


}

