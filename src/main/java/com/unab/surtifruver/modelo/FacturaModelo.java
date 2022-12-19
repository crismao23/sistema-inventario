
package com.unab.surtifruver.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
