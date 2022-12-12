package com.misiontic.fruver.modelos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioModelo {

    @Id
    private String id;
    @NotNull
    private String nombreCompleto;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String rol;
    @NotNull
    private String imagenPerfil;

}
