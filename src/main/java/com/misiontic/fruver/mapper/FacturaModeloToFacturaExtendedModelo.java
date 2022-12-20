package com.misiontic.fruver.mapper;

import com.misiontic.fruver.modelo.*;
import com.misiontic.fruver.servicio.ProductoServicio;
import com.misiontic.fruver.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacturaModeloToFacturaExtendedModelo implements IMapper<FacturaModelo, FacturaExtendedModelo>{

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    ProductoServicio productoServicio;

    @Override
    public FacturaExtendedModelo map(FacturaModelo in) {
        FacturaExtendedModelo facturaExtendedModelo = new FacturaExtendedModelo();
        facturaExtendedModelo.setId(in.getId());
        facturaExtendedModelo.setIdUsuario(in.getIdUsuario());
        facturaExtendedModelo.setFechaCompra(in.getFechaCompra());
        facturaExtendedModelo.setNombreCompleto(usuarioServicio.getUsuarioById(in.getIdUsuario()).get().getNombreCompleto());

        List<ProductoCompradoExtendedModelo> productoExtendedModelos = new ArrayList<>();

        for (ProductoCompradoModelo productoComprado: in.getProductosComprados()) {
            ProductoModelo producto = productoServicio.getProductoById(productoComprado.getIdProducto()).get();
            ProductoCompradoExtendedModelo productoCompradoExtendedModelo = new ProductoCompradoExtendedModelo();
            productoCompradoExtendedModelo.setIdProducto(productoComprado.getIdProducto());
            productoCompradoExtendedModelo.setCantidad(productoComprado.getCantidad());
            productoCompradoExtendedModelo.setNombre(producto.getNombre());
            productoCompradoExtendedModelo.setPrecio(producto.getPrecio());
            productoExtendedModelos.add(productoCompradoExtendedModelo);
        }

        facturaExtendedModelo.setProductosComprados(productoExtendedModelos);

        return facturaExtendedModelo;
    }
}
