package com.unab.fruverapp.controlador;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    @GetMapping("/all")
    public String holaMundo(){
        return "get all";
    }
    @GetMapping("/{id}")
    public String getAllProductos(){
        return "get id";
    }

    @PostMapping("/save")
    public String saveProduct(){
        return "post save";
    }

    @PutMapping("/update/{id}")
    public String updateProducto(){
        return "post/put {id}";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(){
        return "delete {id}";
    }
}
