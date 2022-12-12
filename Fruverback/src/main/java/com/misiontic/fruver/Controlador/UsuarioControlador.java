package com.misiontic.fruver.Controlador;

import com.misiontic.fruver.Modelo.UsuarioModelo;

import java.util.List;

import com.misiontic.fruver.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jjben
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;
    
    @GetMapping("/all")
    public List<UsuarioModelo> getAllUsuarioControl(){
        return usuarioServicio.getAllUsuario();
    }
    
    // @GetMapping("/{id}")
    // public Optional<UsuarioModelo> findUsuarioById(@PathVariable("id") String id){
    //     return usuarioServicio.getUsuarioById(id);
    // }
    @PutMapping("/{id}")
    public String actualizarUsuario(@PathVariable("id") UsuarioModelo u){
        return usuarioServicio.saveUsuario(u);
    }
  @PostMapping("/save")
    public String saveUsuario(@RequestBody UsuarioModelo u){
        return usuarioServicio.saveUsuario(u);
    }

    @DeleteMapping("/{id}")
    public String deletePacienteById(@PathVariable("id") String id){
        return usuarioServicio.deleteById(id);
    }

//    @GetMapping("/query")
//    public List<UsuarioModelo> getPacienteByApellido(@RequestParam("apellido") String apellido){
//        return usuarioServicio.getPacientesByApellido(apellido);
//    }
//
//    @GetMapping("/location")
//    public List<UsuarioModelo> getPacientesByDireccion(@RequestBody Object departamento){
//        return usuarioServicio.getPacientesByDireccion(departamento);
//    }
}