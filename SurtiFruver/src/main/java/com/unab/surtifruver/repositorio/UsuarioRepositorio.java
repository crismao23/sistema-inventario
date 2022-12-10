/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.surtifruver.repositorio;

import com.unab.surtifruver.modelo.UsuarioModelo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

/**
 *
 * @author jjben
 */
@Repository
public interface UsuarioRepositorio extends MongoRepository <UsuarioModelo, String> {
//
//    List<ProductoModelo> findByApellido(String apellido);
//
//    List<ProductoModelo> findByDireccion(Object direccion);
}
