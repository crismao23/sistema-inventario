package com.misiontic.fruver.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jjben
 */
@Document("usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModelo {
    //@Id
    private String id;
    private String nombreCompleto;
    private String password;
    private String email;
    private String rol;
}