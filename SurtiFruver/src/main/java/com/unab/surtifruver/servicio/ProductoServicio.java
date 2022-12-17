package com.unab.surtifruver.servicio;

import com.unab.surtifruver.modelo.ProductoModelo;
import com.unab.surtifruver.repositorio.ProductoRepositorio;

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
            return productoModelo.getNombre() +  " agregado exitosamente";
        } else {
            productoRepositorio.save(productoModelo);
            return "Producto " + productoModelo.getNombre() +  " actualizado exitosamente";
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
            return "Producto " + p.get().getNombre() + " eliminado";
        } else {
            return "No eliminado";
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