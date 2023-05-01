package com.juanprog.demoConsecionario.app.Negocio;

import com.juanprog.demoConsecionario.app.Dto.UsuarioDto;
import com.juanprog.demoConsecionario.app.Entity.Usuario;
import com.juanprog.demoConsecionario.app.Implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioNegocio {
    @Autowired
    private UsuarioImpl usuarioImpl;

    private List<UsuarioDto> listDtoUsuarios;

    public List<UsuarioDto>encontrarTodos(){

        listDtoUsuarios=new ArrayList<>();

        this.usuarioImpl.encontrarTodos().forEach(usuario -> {

            UsuarioDto usuarioDto= new UsuarioDto();

            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setDireccion(usuario.getDireccion());
            usuarioDto.setTelefono(usuario.getTelefono());
            usuarioDto.setEdad(usuario.getEaad());

            this.listDtoUsuarios.add(usuarioDto);

        });
        return this.listDtoUsuarios;

    }
    public String guardarUsuario(UsuarioDto usuarioDto){

        Usuario usuario = new Usuario();

        try{
            if (usuarioDto.getId()!=0){
                usuario.setId(usuarioDto.getId());
                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setDireccion(usuarioDto.getDireccion());
                usuario.setTelefono(usuarioDto.getTelefono());
                usuario.setEaad(usuarioDto.getEdad());

                this.usuarioImpl.actualizarUsuario(usuario);

            }else{

                usuario.setNombre(usuarioDto.getNombre());
                usuario.setApellido(usuarioDto.getApellido());
                usuario.setCorreo(usuarioDto.getCorreo());
                usuario.setDireccion(usuarioDto.getDireccion());
                usuario.setTelefono(usuarioDto.getTelefono());
                usuario.setEaad(usuarioDto.getEdad());

                this.usuarioImpl.crearUsuario(usuario);
            }
            return "Ok";
        }catch (Exception e){
            return "bad";
        }
    }
}
