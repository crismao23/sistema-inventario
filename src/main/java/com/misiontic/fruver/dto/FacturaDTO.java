package com.misiontic.fruver.dto;

import com.misiontic.fruver.modelo.ProductoCompradoExtendedModelo;
import com.misiontic.fruver.modelo.ProductoCompradoModelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturaDTO {

    private String id;
    private String nombreCompleto;
    private String fechaCompra;
    private List<ProductoCompradoExtendedModelo> productosCompradosExtended;
    private Long subtotal;
}
