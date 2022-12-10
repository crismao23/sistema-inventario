/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.surtifruver.repositorio;

import com.unab.surtifruver.modelo.ProductoModelo;
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
