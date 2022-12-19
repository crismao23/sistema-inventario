package com.misiontic.fruver.servicio;

import com.misiontic.fruver.modelo.UsuarioModelo;
import com.misiontic.fruver.repositorio.UsuarioRepositorio;
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
        usuario.setNombreCompleto(usuario.getNombreCompleto().toLowerCase());

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

    public Optional<UsuarioModelo> getUsuarioById(String id) {
        return usuarioRepositorio.findById(id);
    }

}
