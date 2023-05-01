package com.juanprog.demoConsecionario.app.Controlador;

import com.juanprog.demoConsecionario.app.Dto.UsuarioDto;
import com.juanprog.demoConsecionario.app.Negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/usuarios")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})
public class UsuarioControler {

    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @GetMapping( "/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> traerTodos(){
        Map<String,Object> resp=new HashMap<>();
        List<UsuarioDto> listDto=this.usuarioNegocio.encontrarTodos();
        resp.put("Status", HttpStatus.ACCEPTED);
        resp.put("data",listDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity <Map<String, Object>> crearUsuario(@RequestBody Map<String, Object> request){
        Map<String,Object> resp=new HashMap<>();


        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setEdad(Integer.parseInt(request.get("edad").toString()));
        usuarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());

        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);

        resp.put("Status",HttpStatus.ACCEPTED);
        resp.put("data",respuesta);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
