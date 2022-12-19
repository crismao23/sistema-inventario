package com.misiontic.fruver.mapper;

import com.misiontic.fruver.dto.FacturaDTO;
import com.misiontic.fruver.modelo.FacturaModelo;
import com.misiontic.fruver.modelo.ProductoCompradoExtendedModelo;
import com.misiontic.fruver.modelo.ProductoCompradoModelo;
import com.misiontic.fruver.modelo.UsuarioModelo;
import com.misiontic.fruver.servicio.ProductoServicio;
import com.misiontic.fruver.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Component
public class FacturaToFacturaDTO implements IMapper<FacturaModelo, FacturaDTO>{

    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    ProductoServicio productoServicio;
    @Override
    public FacturaDTO map(FacturaModelo in) {

        FacturaDTO facturaDTO = new FacturaDTO();

        facturaDTO.setId(in.getId());
        facturaDTO.setFechaCompra(in.getFechaCompra());

        UsuarioModelo usuario = usuarioServicio.getUsuarioById(in.getIdUsuario()).get();
        facturaDTO.setNombreCompleto(usuario.getNombreCompleto());

        facturaDTO.setSubtotal(in.getSubtotal());



        List<ProductoCompradoExtendedModelo> productoCompradoExtendedModelos = new ArrayList<>();

        for (ProductoCompradoModelo productoCompradoModelo : in.getProductosComprados()) {
            ProductoCompradoExtendedModelo productoCompradoExtendedModelo = new ProductoCompradoExtendedModelo();
            productoCompradoExtendedModelo.setNombre( productoServicio.getProductoById(productoCompradoModelo.getIdProducto()).get().getNombre());
            productoCompradoExtendedModelo.setPrecio( productoServicio.getProductoById(productoCompradoModelo.getIdProducto()).get().getPrecio());
            productoCompradoExtendedModelo.setCantidad( productoCompradoModelo.getCantidad());
            productoCompradoExtendedModelos.add(productoCompradoExtendedModelo);
        }

        facturaDTO.setProductosCompradosExtended(productoCompradoExtendedModelos);

        return facturaDTO;
    }
}
