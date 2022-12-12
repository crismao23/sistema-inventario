package com.misiontic.fruver.Servicio;

import com.misiontic.fruver.Modelo.FacturaModelo;
import com.misiontic.fruver.Modelo.ProductoModelo;
import com.misiontic.fruver.Repositorio.FacturaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    FacturaRepositorio facturaRepositorio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    UsuarioServicio usuarioServicio;

    public String saveFactura(FacturaModelo factura) {

        if (factura.getId() == null || !facturaRepositorio.existsById(factura.getId())) {
            factura.setSubtotal(calcularSubtotal(factura));
            facturaRepositorio.save(factura);
//            actualizarInventario(factura);
            return "Se agregó una nueva factura";
        } else {
            factura.setSubtotal(calcularSubtotal(factura));
            facturaRepositorio.save(factura);
//            actualizarInventario(factura);
            return "factura ACTUALIZADA";
        }
    }

    public List<FacturaModelo> getAllFacturas() {
        List<FacturaModelo> listafacturas = facturaRepositorio.findAll();
        listafacturas.sort(Comparator.comparing(FacturaModelo::getId));
        return listafacturas;
    }

    public String deleteById(String id) {
        if (facturaRepositorio.existsById(id)) {
            Optional<FacturaModelo> p = facturaRepositorio.findById(id);
            facturaRepositorio.deleteById(id);
            return "factura " + p.get().getId() + " eliminado";
        } else {
            return "NO ELIMINADO";
        }
    }

    public int calcularSubtotal(FacturaModelo factura){
        Optional <ProductoModelo> precioUnitario = productoServicio.getProductoById(factura.getIdProducto());

        return precioUnitario.get().getPrecio() * factura.getCantProductosComprados();
    }

    public Optional<FacturaModelo> getFacturaById(String id) {
        return facturaRepositorio.findById(id);
    }

//    public void actualizarInventario(FacturaModelo factura){
//        productoServicio = productoServicio.getProductoById(factura.getIdProducto());
//        Integer inventarioPreFactura = producto.get().getInventario();
//        Integer cantProductosFacturados = factura.getCantProductosComprados();
//        Integer inventarioActualizado = inventarioPreFactura - cantProductosFacturados;
//        producto.get().setInventario(inventarioActualizado);
//        producto.get().setId(factura.getIdProducto());
//        producto.get().setCategoria(producto.get().getCategoria());
//        producto.get().setPrecio(producto.get().getPrecio());
//        producto.get().setInventario(inventarioActualizado);
//        productoServicio.save(producto);
//        System.out.println(producto);
////
//        producto.get().setInventario(producto.get().getInventario() - factura.getCantProductosComprados());
//    }
//                getCantProductosComprados();
//        for (int i = 0; i < productos.size(); i++)
//            System.out.println(productos.get(i).getNombre() + "= " + productos.get(i).getInventario());
//        }
//https://app.getpostman.com/join-team?invite_code=d9a794774d1e0ddd7a8c17b5ff94e4ae
}