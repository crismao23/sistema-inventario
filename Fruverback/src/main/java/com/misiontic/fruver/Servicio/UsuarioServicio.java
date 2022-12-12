package com.misiontic.fruver.Servicio;

import com.misiontic.fruver.Modelo.UsuarioModelo;
import com.misiontic.fruver.Repositorio.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public String saveUsuario(UsuarioModelo usuario) {
//        usuario.setNombre(usuario.getNombre().toLowerCase());
//        usuario.setApellido(usuario.getApellido().toLowerCase());

        if (usuario.getId() == null || !usuarioRepositorio.existsById(usuario.getId())) {
            usuarioRepositorio.save(usuario);
            return "Se agregó un nuevo usuario";
        } else {
            usuarioRepositorio.save(usuario);
            return "usuario ACTUALIZADO";
        }
    }

    public List<UsuarioModelo> getAllUsuario() {
        List<UsuarioModelo> listaUsuarios = usuarioRepositorio.findAll();
        listaUsuarios.sort(Comparator.comparing(UsuarioModelo::getId));
        return listaUsuarios;
    }

    public String deleteById(String id) {
        if (usuarioRepositorio.existsById(id)) {
            Optional<UsuarioModelo> p = usuarioRepositorio.findById(id);
            usuarioRepositorio.deleteById(id);
            return "usuario " + p.get().getNombreCompleto() + " eliminado";
        } else {
            return "NO ELIMINADO";
        }

    }

    public Optional<UsuarioModelo> getProductoById(String id) {
        return usuarioRepositorio.findById(id);
    }
//
//    public List<UsuarioModelo> getusuariosByApellido(String apellido) {
//        return usuarioRepositorio.findByApellido(apellido);
//    }
//
//    public List<UsuarioModelo> getusuariosByDireccion(Object direccion) {
//        return usuarioRepositorio.findByDireccion(direccion);
//    }
//https://app.getpostman.com/join-team?invite_code=d9a794774d1e0ddd7a8c17b5ff94e4ae
}