package com.misiontic.fruver.Controlador;

import com.misiontic.fruver.Modelo.ProductoModelo;
import java.util.List;
import java.util.Optional;

import com.misiontic.fruver.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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