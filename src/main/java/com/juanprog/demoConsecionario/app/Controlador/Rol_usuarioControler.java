package com.juanprog.demoConsecionario.app.Controlador;

import com.juanprog.demoConsecionario.app.Dto.Rol_UsuarioDto;
import com.juanprog.demoConsecionario.app.Negocio.Rol_UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Rol_Usuarios")
@CrossOrigin(origins = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})
public class Rol_usuarioControler {

    @Autowired
    private Rol_UsuarioNegocio rol_usuarioNegocio;

    @Autowired
    private Rol_UsuarioDto rol_usuarioDto;

    @GetMapping( "/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> traerTodos(){
        Map<String,Object> resp=new HashMap<>();
        List<Rol_UsuarioDto> listDto=this.rol_usuarioNegocio.encontrarTodos();
        resp.put("Status", HttpStatus.ACCEPTED);
        resp.put("data",listDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
    @GetMapping( "/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearRol_usuario(
            @RequestParam Map<String,Object>request) {
        Map<String, Object> resp = new HashMap<>();
        rol_usuarioDto.setId(0);
        rol_usuarioDto.setRol_usuario(request.get("rol_usuario").toString());
        String respuesta = this.rol_usuarioNegocio.guardarRol_Usuario(rol_usuarioDto);
        resp.put("Status", "ok");
        resp.put("data", respuesta);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
