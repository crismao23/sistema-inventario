
package com.misiontic.fruver.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jjben
 */
@Document("factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturaModelo {
    @Id
    private String id;
    private LocalDate fechaCompra;
    private String IdUsuario;
    private List<ProductoCompradoModelo> productosComprados;
    private Long subtotal;
}
