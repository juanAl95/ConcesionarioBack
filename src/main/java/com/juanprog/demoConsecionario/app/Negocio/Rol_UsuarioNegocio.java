package com.juanprog.demoConsecionario.app.Negocio;

import com.juanprog.demoConsecionario.app.Dto.Rol_UsuarioDto;
import com.juanprog.demoConsecionario.app.Entity.Rol_Usuario;
import com.juanprog.demoConsecionario.app.Implementacion.Rol_UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Rol_UsuarioNegocio {
    @Autowired
    private Rol_UsuarioImpl rol_usuarioImpl;

    private List<Rol_UsuarioDto> listDtoRol_Usuarios=new ArrayList<>();

    public List<Rol_UsuarioDto>encontrarTodos(){
        this.rol_usuarioImpl.encontrarTodos().forEach(el->{
            Rol_UsuarioDto rolUsuarioDto=new Rol_UsuarioDto();
            rolUsuarioDto.setId(rolUsuarioDto.getId());
            rolUsuarioDto.setRol_usuario(rolUsuarioDto.getRol_usuario());
            this.listDtoRol_Usuarios.add(rolUsuarioDto);
        });
        return this.listDtoRol_Usuarios;
    }
    public String guardarRol_Usuario(Rol_UsuarioDto rol_usuarioDto){
        Rol_Usuario rol_usuario=new Rol_Usuario();
        try{
            if(rol_usuario.getId()!=0){
                rol_usuario.setId(rol_usuario.getId());
                rol_usuario.setRol_usuario(rol_usuario.getRol_usuario());
                this.rol_usuarioImpl.actualizarRol_Usuario(rol_usuario);
            }else{
                rol_usuario.setId(rol_usuario.getId());
                rol_usuario.setRol_usuario(rol_usuario.getRol_usuario());
                this.rol_usuarioImpl.crearRol_Usuario(rol_usuario);
            }
            return "ok";
        }catch(Exception e){
            return "bad";
        }
    }
}
