package com.misiontic.fruver.controladores;

import com.misiontic.fruver.modelos.UsuarioModelo;
import com.misiontic.fruver.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    private List<UsuarioModelo> verUsuarios(){
        return this.usuarioServicio.getListaUsuarios();
    }

    @GetMapping("/{id}")
    private Optional<UsuarioModelo> verUsuario(@PathVariable("id") String id){
        return this.usuarioServicio.getUsuarioPorId(id);
    }

    @PostMapping()
    public String guardarUsuario(@RequestBody UsuarioModelo usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }


}
