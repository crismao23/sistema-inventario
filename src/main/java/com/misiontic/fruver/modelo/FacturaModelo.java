
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
public class FacturaModelo {
    @Id
    private String id;
    private String fechaCompra;
    private String idUsuario;
    private List<ProductoCompradoModelo> productosComprados;
    private Long subtotal;
}
