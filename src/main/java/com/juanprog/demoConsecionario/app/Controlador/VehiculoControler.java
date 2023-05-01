package com.juanprog.demoConsecionario.app.Controlador;

import com.juanprog.demoConsecionario.app.Dto.UsuarioDto;
import com.juanprog.demoConsecionario.app.Dto.VehiculoDto;
import com.juanprog.demoConsecionario.app.Implementacion.VehiculoImpl;
import com.juanprog.demoConsecionario.app.Entity.Vehiculo;
import com.juanprog.demoConsecionario.app.Negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/vehiculos")
@CrossOrigin(origins = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})
public class VehiculoControler {

    @Autowired
    private VehiculoNegocio vehiculoNegocio;

    @Autowired
    private VehiculoDto vehiculoDto;

    @GetMapping( "/all")
    @ResponseBody
        public ResponseEntity<Map<String,Object>> traerTodos(){
        Map<String,Object> resp=new HashMap<>();
        List<VehiculoDto> listDto=this.vehiculoNegocio.encontrarTodos();
        resp.put("Status", HttpStatus.ACCEPTED);
        resp.put("data",listDto);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>crearUsuario(@RequestBody Map<String,Object>request){
        Map<String,Object> resp=new HashMap<>();

        VehiculoDto vehiculodto = new VehiculoDto();

        vehiculoDto.setId(0);
        vehiculoDto.setPrecio(request.get("precio").toString());
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setColor(request.get("color").toString());

        String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        resp.put("Status",  HttpStatus.ACCEPTED);
        resp.put("data",respuesta);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
}
