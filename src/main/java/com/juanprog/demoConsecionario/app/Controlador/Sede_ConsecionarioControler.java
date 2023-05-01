package com.juanprog.demoConsecionario.app.Controlador;

import com.juanprog.demoConsecionario.app.Dto.Sede_ConsecionarioDto;
import com.juanprog.demoConsecionario.app.Implementacion.Sede_ConsecionarioImpl;
import com.juanprog.demoConsecionario.app.Entity.Sede_Consecionario;
import com.juanprog.demoConsecionario.app.Negocio.Sede_ConsecionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/consecionarios")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class Sede_ConsecionarioControler {


    @Autowired
    private Sede_ConsecionarioNegocio sede_consecionarioNegocio;

    /*@Autowired
    private Sede_ConsecionarioDto sede_consecionarioDto;

     */
    @GetMapping( "/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> traerTodos(){
        Map<String,Object> resp=new HashMap<>();
        List<Sede_ConsecionarioDto> listDto=this.sede_consecionarioNegocio.encontrarTodos();
        resp.put("Status", HttpStatus.ACCEPTED);
        resp.put("data",listDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }


    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearSedeConsecionaro(
        @RequestBody Map<String,Object>request) {
        Map<String, Object> resp = new HashMap<>();

        Sede_ConsecionarioDto sede_consecionarioDto = new Sede_ConsecionarioDto();
        sede_consecionarioDto.setId(0);
        sede_consecionarioDto.setNombre_sede(request.get("nombreSede").toString());
        sede_consecionarioDto.setDireccion(request.get("direccion").toString());
        String respuesta = this.sede_consecionarioNegocio.guardarSede_Consecionario(sede_consecionarioDto);
        resp.put("Status", HttpStatus.ACCEPTED);
        resp.put("data", respuesta);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
