/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.fruver.contolador;

import com.misiontic.fruver.modelo.UsuarioModelo;
import com.misiontic.fruver.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
