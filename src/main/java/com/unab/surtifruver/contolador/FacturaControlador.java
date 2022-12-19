/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.surtifruver.contolador;

import com.unab.surtifruver.modelo.FacturaModelo;
import com.unab.surtifruver.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jjben
 */
@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturaControlador {
    @Autowired
    FacturaServicio facturaServicio;
    
    @GetMapping("/all")
    public List<FacturaModelo> getAllFactura(){
        return facturaServicio.getAllFacturas();
    }
    
    @GetMapping("/{id}")
    public Optional<FacturaModelo> findFacturaById(@PathVariable("id") String id){
        return facturaServicio.getFacturaById(id);
    }
    @PutMapping("/{id}")
    public String actualizarFactura(@PathVariable("id") FacturaModelo p){
        return facturaServicio.saveFactura(p);
    }
  @PostMapping("/save")
    public String saveFactura(@RequestBody FacturaModelo p){
        return facturaServicio.saveFactura(p);
    }

    @DeleteMapping("/{id}")
    public String deleteFacturaById(@PathVariable("id") String id){
        return facturaServicio.deleteById(id);
    }
    
}
