/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.surtifruver.contolador;

import com.unab.surtifruver.modelo.ProductoModelo;
import java.util.List;
import java.util.Optional;

import com.unab.surtifruver.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jjben
 */
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;
    
    @GetMapping("/all")
    public List<ProductoModelo> getAllProductos(){
        return productoServicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<ProductoModelo> findPacienteById(@PathVariable("id") String id){
        return productoServicio.getProductoById(id);
    }
    @PutMapping("/{id}")
    public String actualizarProducto(@PathVariable("id") ProductoModelo p){
        return productoServicio.save(p);
    }
  @PostMapping("/save")
    public String savePaciente(@RequestBody ProductoModelo p){
        return productoServicio.save(p);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id){
        return productoServicio.deleteById(id);
    }

//    @GetMapping("/query")
//    public List<ProductoModelo> getPacienteByApellido(@RequestParam("apellido") String apellido){
//        return productoServicio.getPacientesByApellido(apellido);
//    }
//
//    @GetMapping("/location")
//    public List<ProductoModelo> getPacientesByDireccion(@RequestBody Object departamento){
//        return productoServicio.getPacientesByDireccion(departamento);
//    }
}
