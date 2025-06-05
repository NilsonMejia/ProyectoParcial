package edu.sv.catolica.ProyectoParcial.dto;

import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaDTO {

    private long BibliotecaID;
    private LibroEntity libro;
    private String Titulo;
    private Long AutorID;
    private Long LibroID;
    private Long PrestamoID;
    private PrestamoEntity prestamo;
    private LocalDate FechaPrestamo;
    private LocalDate FechaDevolucion;
    private Boolean Disponible;

}
