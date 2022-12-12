package com.misiontic.fruver.Servicio;
import com.misiontic.fruver.Modelo.ProductoModelo;
import com.misiontic.fruver.Repositorio.ProductoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {
    @Autowired
    ProductoRepositorio productoRepositorio;

    public String save(ProductoModelo productoModelo) {
//        paciente.setNombre(paciente.getNombre().toLowerCase());
//        paciente.setApellido(paciente.getApellido().toLowerCase());

        if (productoModelo.getId() == null || !productoRepositorio.existsById(productoModelo.getId())) {
            productoRepositorio.save(productoModelo);
            return "Se agregó un nuevo PRODUCTO";
        } else {
            productoRepositorio.save(productoModelo);
            return "PRODUCTO ACTUALIZADO";
        }
    }

    public List<ProductoModelo> getAll() {
        List<ProductoModelo> listaPacientes = productoRepositorio.findAll();
        listaPacientes.sort(Comparator.comparing(ProductoModelo::getId));
        return listaPacientes;
    }

    public String deleteById(String id) {
        if (productoRepositorio.existsById(id)) {
            Optional<ProductoModelo> p = productoRepositorio.findById(id);
            productoRepositorio.deleteById(id);
            return "PRODUCTO " + p.get().getNombre() + " eliminado";
        } else {
            return "NO ELIMINADO";
        }

    }

    public Optional<ProductoModelo> getProductoById(String id) {
        return productoRepositorio.findById(id);
    }
//
//    public List<ProductoModelo> getPacientesByApellido(String apellido) {
//        return productoRepositorio.findByApellido(apellido);
//    }
//
//    public List<ProductoModelo> getPacientesByDireccion(Object direccion) {
//        return productoRepositorio.findByDireccion(direccion);
//    }
//https://app.getpostman.com/join-team?invite_code=d9a794774d1e0ddd7a8c17b5ff94e4ae
}
