/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.fruver.repositorio;

import com.misiontic.fruver.modelo.FacturaExtendedModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacturaRepositorio extends MongoRepository <FacturaExtendedModelo, String> {

    List<FacturaExtendedModelo> findByIdUsuario(String idUsuario);

}
