package com.misiontic.fruver.servicio;

import com.misiontic.fruver.dto.FacturaDTO;
import com.misiontic.fruver.mapper.FacturaToFacturaDTO;
import com.misiontic.fruver.modelo.FacturaModelo;
import com.misiontic.fruver.modelo.ProductoCompradoModelo;
import com.misiontic.fruver.modelo.ProductoModelo;
import com.misiontic.fruver.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    FacturaToFacturaDTO mapper;

    public String saveFactura(FacturaModelo factura) {

        if (factura.getId() == null || !facturaRepositorio.existsById(factura.getId())) {
            factura.setSubtotal(calcularSubtotal(factura));
            facturaRepositorio.save(factura);
            return "Se agregó una nueva factura";
        } else {
            factura.setSubtotal(calcularSubtotal(factura));
            facturaRepositorio.save(factura);
            return "factura actualizada";
        }
    }

    public List<FacturaModelo> getAllFacturas() {
        List<FacturaModelo> listafacturas = facturaRepositorio.findAll();
        listafacturas.sort(Comparator.comparing(FacturaModelo::getId));
        return listafacturas;
    }

    public List<FacturaDTO> getAllFacturasExtended() {
        List<FacturaModelo> listafacturas = facturaRepositorio.findAll();
        listafacturas.sort(Comparator.comparing(FacturaModelo::getId));
        List<FacturaDTO> facturaDTOS = new ArrayList<>();

        for (FacturaModelo factura: listafacturas) {
            facturaDTOS.add(mapper.map(factura));
        }
        return facturaDTOS;
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

    public Long calcularSubtotal(FacturaModelo factura){
        long subtotal = 0;
        int cantidad = 0;
        List<ProductoCompradoModelo> productoCompradoModelos = factura.getProductosComprados();

        for (ProductoCompradoModelo productoFactura: productoCompradoModelos) {
             ProductoModelo producto = productoServicio.getProductoById(productoFactura.getIdProducto()).get();
             subtotal += (producto.getPrecio() * productoFactura.getCantidad());
        }
        return subtotal;
    }
    public Optional<FacturaModelo> getFacturaById(String id) {
        return facturaRepositorio.findById(id);
    }

    public List<FacturaModelo> getFacturasByIdUsuario(String idUsuario){
        return facturaRepositorio.findByIdUsuario(idUsuario);
    }

}
