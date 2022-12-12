package com.misiontic.fruver.Repositorio;

import com.misiontic.fruver.Modelo.FacturaModelo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends MongoRepository <FacturaModelo, String> {

}