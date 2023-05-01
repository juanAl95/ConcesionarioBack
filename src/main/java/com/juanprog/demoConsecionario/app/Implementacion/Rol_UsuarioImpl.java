package com.juanprog.demoConsecionario.app.Implementacion;

import com.juanprog.demoConsecionario.app.Repositorio.RepositoryRol_Usuario;
import com.juanprog.demoConsecionario.app.Servicio.Rol_UsuarioServicio;
import com.juanprog.demoConsecionario.app.Entity.Rol_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rol_UsuarioImpl implements Rol_UsuarioServicio {

    @Autowired
    RepositoryRol_Usuario repositoryRol_usuario;

    @Override
    public List<Rol_Usuario> encontrarTodos() {

        return this.repositoryRol_usuario.findAll();

    }

    @Override
    public Rol_Usuario encontrarPorId(int id) {

        return this.repositoryRol_usuario.encontrarId(id);
    }

    @Override
    public void actualizarRol_Usuario(Rol_Usuario rol_usuario) {

        this.repositoryRol_usuario.save(rol_usuario);

    }

    @Override
    public void crearRol_Usuario(Rol_Usuario rol_usuario) {

        this.repositoryRol_usuario.save(rol_usuario);

    }

    @Override
    public void eliminarRol_Usario(int id) {
        Rol_Usuario rol_usuario=this.repositoryRol_usuario.encontrarId(id);
       if(rol_usuario!=null){
           this.repositoryRol_usuario.delete(rol_usuario);
       }

    }

}
