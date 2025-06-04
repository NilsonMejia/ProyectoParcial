package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDTO2 {
    private Long prestamoID;
    private String Titulo;
    private String nombreUsuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Boolean Disponible;
    private Long AutorID;
}
