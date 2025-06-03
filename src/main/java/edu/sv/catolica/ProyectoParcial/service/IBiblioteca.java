package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IBiblioteca {
    List<BibliotecaEntity> findAll();
    BibliotecaEntity save(BibliotecaEntity biblioteca);
    List<BibliotecaDTO> findFechaDevolucion(LocalDate fechaDevolucion);


}