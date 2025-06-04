package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    private long libroID;
    private String Titulo;
    private Long AutorID;
    private LocalDate Publicacion;
    private String Genero;
    private Boolean Disponible;
}
