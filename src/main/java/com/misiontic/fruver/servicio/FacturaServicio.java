package com.misiontic.fruver.servicio;

import com.misiontic.fruver.mapper.FacturaModeloToFacturaExtendedModelo;
import com.misiontic.fruver.modelo.FacturaExtendedModelo;
import com.misiontic.fruver.modelo.FacturaModelo;
import com.misiontic.fruver.modelo.ProductoCompradoExtendedModelo;
import com.misiontic.fruver.modelo.ProductoModelo;
import com.misiontic.fruver.repositorio.FacturaRepositorio;
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

    @Autowired
    FacturaModeloToFacturaExtendedModelo mapper;


    public String saveFactura(FacturaModelo factura) {

        FacturaExtendedModelo facturaExtendedModelo = mapper.map(factura);

        if (facturaExtendedModelo.getId() == null || !facturaRepositorio.existsById(facturaExtendedModelo.getId())) {
            facturaExtendedModelo.setSubtotal(calcularSubtotal(facturaExtendedModelo));
            facturaRepositorio.save(facturaExtendedModelo);
            return "Se agregó una nueva factura";
        } else {
            facturaExtendedModelo.setSubtotal(calcularSubtotal(facturaExtendedModelo));
            facturaRepositorio.save(facturaExtendedModelo);
            return "factura actualizada";
        }
    }

    public List<FacturaExtendedModelo> getAllFacturas() {
        List<FacturaExtendedModelo> listafacturas = facturaRepositorio.findAll();
        listafacturas.sort(Comparator.comparing(FacturaExtendedModelo::getId));
        return listafacturas;
    }

    public String deleteById(String id) {
        if (facturaRepositorio.existsById(id)) {
            Optional<FacturaExtendedModelo> p = facturaRepositorio.findById(id);
            facturaRepositorio.deleteById(id);
            return "factura " + p.get().getId() + " eliminado";
        } else {
            return "NO ELIMINADO";
        }
    }

    public Long calcularSubtotal(FacturaExtendedModelo factura){
        long subtotal = 0;
        List<ProductoCompradoExtendedModelo> productoCompradoModelos = factura.getProductosComprados();

        for (ProductoCompradoExtendedModelo productoFactura: productoCompradoModelos) {
             ProductoModelo producto = productoServicio.getProductoById(productoFactura.getIdProducto()).get();
             subtotal += (producto.getPrecio() * productoFactura.getCantidad());
        }
        return subtotal;
    }
    public Optional<FacturaExtendedModelo> getFacturaById(String id) {
        return facturaRepositorio.findById(id);
    }

    public List<FacturaExtendedModelo> getFacturasByIdUsuario(String idUsuario){
        return facturaRepositorio.findByIdUsuario(idUsuario);
    }

}
