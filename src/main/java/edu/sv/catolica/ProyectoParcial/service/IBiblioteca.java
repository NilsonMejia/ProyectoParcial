package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO2;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;

import java.time.LocalDate;
import java.util.List;

public interface IBiblioteca {
    List<BibliotecaEntity> findAll();
    BibliotecaEntity save(BibliotecaEntity biblioteca);
    List<BibliotecaDTO2> findFechaDevolucion(LocalDate fechaDevolucion);


    void delete(Long id);
}