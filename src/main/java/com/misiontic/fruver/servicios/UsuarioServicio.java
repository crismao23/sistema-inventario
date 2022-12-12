package com.misiontic.fruver.servicios;

import com.misiontic.fruver.modelos.UsuarioModelo;
import com.misiontic.fruver.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public String guardarUsuario(UsuarioModelo usuario) {
        try {
            if (usuarioRepositorio.existsById(usuario.getId())){
                usuarioRepositorio.save(usuario);
                return "Se Actualizo El Usuario";
            } else {
                usuarioRepositorio.save(usuario);
                return "Se Guardo El Usuario";
            }
        } catch (Exception e) {
            return HttpStatus.BAD_GATEWAY.getReasonPhrase();
        }
    }

    public List<UsuarioModelo> getListaUsuarios(){
        List<UsuarioModelo> listaUsuarios = usuarioRepositorio.findAll();
        listaUsuarios.sort(Comparator.comparing(UsuarioModelo::getNombreCompleto));
        return listaUsuarios;
    }

    public Optional<UsuarioModelo> getUsuarioPorId(String id){
        return usuarioRepositorio.findById(id);
    }

    public String eliminarUsuarioPorId(String id){
        if (usuarioRepositorio.existsById(id)) {
            Optional<UsuarioModelo> usuario = usuarioRepositorio.findById(id);
            usuarioRepositorio.deleteById(id);
            return "Usuario "+usuario.get().getNombreCompleto()+" Eliminado";
        } else {
            return "No Eliminado";
        }
    }

}
