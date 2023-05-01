package com.juanprog.demoConsecionario.app.Controlador;

import com.juanprog.demoConsecionario.app.Dto.VentaDto;
import com.juanprog.demoConsecionario.app.Negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/ventas")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class VentaControler {

    @Autowired
    private VentaNegocio ventaNegocio;

    //@Autowired
    //private VentaDto ventaDto;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> mostrarVentas() {
        Map<String, Object> res = new HashMap<>();
        List<VentaDto> listVentaDto = this.ventaNegocio.encontrarTodos();
        res.put("status", HttpStatus.CREATED);
        res.put("data", listVentaDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> crearVenta(@RequestBody Map<String, Object> request) {
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@@@@"+request.toString());
        VentaDto ventaDto = new VentaDto();

        ventaDto.setId(0);
        ventaDto.setFecha(new Date());
        ventaDto.setValor(Integer.parseInt(request.get("velor").toString()));

        String respuesta = this.ventaNegocio.guardarVentas(ventaDto);


        res.put("status", HttpStatus.CREATED);
        res.put("data", respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
