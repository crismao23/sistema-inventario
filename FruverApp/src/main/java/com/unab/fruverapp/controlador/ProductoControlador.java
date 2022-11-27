package com.unab.fruverapp.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class ProductoControlador {
    @GetMapping()
    public String holaMundo(){
        return "Hola mundo";
    }
}
