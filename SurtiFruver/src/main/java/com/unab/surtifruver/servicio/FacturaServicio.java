package com.unab.surtifruver.servicio;

import com.unab.surtifruver.modelo.FacturaModelo;
import com.unab.surtifruver.modelo.ProductoModelo;
import com.unab.surtifruver.repositorio.FacturaRepositorio;
import com.unab.surtifruver.repositorio.ProductoRepositorio;

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
            actualizarInventario();
            return "Se agregó una nueva factura";
        } else {
            factura.setSubtotal(calcularSubtotal(factura));
            facturaRepositorio.save(factura);
            actualizarInventario();
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

    public int calcularSubtotal(FacturaModelo factura) {
        Optional<ProductoModelo> precioUnitario = productoServicio.getProductoById(factura.getIdProducto());

        return precioUnitario.get().getPrecio() * factura.getCantProductosComprados();
    }

    public Optional<FacturaModelo> getFacturaById(String id) {
        return facturaRepositorio.findById(id);
    }

    public void actualizarInventario() {
        List<FacturaModelo> listaFacturas = facturaRepositorio.findAll();
        for (FacturaModelo factura : listaFacturas) {
            Optional<ProductoModelo> productoActualizar = productoServicio.getProductoById(factura.getIdProducto());
            String nombreProducto = productoActualizar.get().getNombre();
            Integer inventarioProducto = productoActualizar.get().getInventario();
            Integer inventarioActualizado = inventarioProducto - factura.getCantProductosComprados();
            System.out.println("---------------------\nId de factura: " + factura.getId());
            System.out.println("Inventario de " + nombreProducto + " antes de la facturación: " + inventarioProducto);
            System.out.println("Cantidad facturada de " + nombreProducto + ": " + factura.getCantProductosComprados());
            System.out.println("Inventario de " + nombreProducto + " después de la facturación: " + inventarioActualizado);
            productoActualizar.get().setInventario(inventarioActualizado);
            ProductoModelo jsonActualizado = new ProductoModelo(nombreProducto, nombreProducto, nombreProducto, inventarioProducto, inventarioActualizado, nombreProducto, nombreProducto);
            
        }
    }
}
