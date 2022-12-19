
package com.misiontic.fruver.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductoModelo {

    @Id
    private String id;
    private String nombre;
    private String categoria;
    private Integer precio;
    private Integer inventario;
    private String descripcion;
    private String urlImage;

}
