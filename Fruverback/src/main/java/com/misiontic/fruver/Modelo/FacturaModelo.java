package com.misiontic.fruver.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private String idProducto;
    private Integer cantProductosComprados;
    private Integer subtotal;
}