
package com.misiontic.fruver.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturaExtendedModelo {
    @Id
    private String id;
    private String nombreCompleto;
    private String fechaCompra;
    private String idUsuario;
    private List<ProductoCompradoExtendedModelo> productosComprados;
    private Long subtotal;
}
