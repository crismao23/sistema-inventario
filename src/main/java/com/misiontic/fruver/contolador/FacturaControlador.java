
package com.misiontic.fruver.contolador;

import com.misiontic.fruver.modelo.FacturaExtendedModelo;
import com.misiontic.fruver.modelo.FacturaModelo;
import com.misiontic.fruver.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturaControlador {
    @Autowired
    FacturaServicio facturaServicio;
    
    @GetMapping("/all")
    public List<FacturaExtendedModelo> getAllFactura(){
        return facturaServicio.getAllFacturas();
    }
    
    @GetMapping("/{id}")
    public Optional<FacturaExtendedModelo> findFacturaById(@PathVariable("id") String id){
        return facturaServicio.getFacturaById(id);
    }

    @GetMapping("/id-usuario/{id}")
    public List<FacturaExtendedModelo> findFacturasByUsuarioId(@PathVariable("id") String id){
        return facturaServicio.getFacturasByIdUsuario(id);
    }

    @PostMapping("/save")
    public String saveFactura(@RequestBody FacturaModelo facturaModelo){
        return facturaServicio.saveFactura(facturaModelo);
    }

    @DeleteMapping("/{id}")
    public String deleteFacturaById(@PathVariable("id") String id){
        return facturaServicio.deleteById(id);
    }
    
}
