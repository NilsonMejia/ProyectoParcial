package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data

@NoArgsConstructor
public class BibliotecaDTO2 {


        private String Titulo;
        private LocalDate FechaDevolucion;


    public BibliotecaDTO2(String titulo, LocalDate fechaDevolucion) {
        Titulo = titulo;
        this.FechaDevolucion = fechaDevolucion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public LocalDate getFechaDevolucion() {
        return FechaDevolucion;
    }

}
