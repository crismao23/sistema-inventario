package com.misiontic.fruver.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.fruver.Modelo.UsuarioModelo;

@Repository
public interface UsuarioRepositorio extends MongoRepository <UsuarioModelo, String> {

}
