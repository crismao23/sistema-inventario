package com.misiontic.fruver.Repositorio;

import com.misiontic.fruver.Modelo.ProductoModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jjben
 */
@Repository
public interface ProductoRepositorio extends MongoRepository <ProductoModelo, String> {
//
//    List<ProductoModelo> findByApellido(String apellido);
//
//    List<ProductoModelo> findByDireccion(Object direccion);

}
