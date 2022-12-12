package com.misiontic.fruver.repositorios;

import com.misiontic.fruver.modelos.UsuarioModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends MongoRepository<UsuarioModelo, String> {
}
