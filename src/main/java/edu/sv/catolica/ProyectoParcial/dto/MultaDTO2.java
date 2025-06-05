package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultaDTO2 {
    private Long multaId;
    private Long usuarioID;
    private LocalDate fechaGeneracion;
    private BigDecimal monto;
    private Boolean estado;
}
