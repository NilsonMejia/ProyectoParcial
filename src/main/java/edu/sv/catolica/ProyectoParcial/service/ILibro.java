package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import java.util.List;

public interface ILibro {
    List<LibroEntity> findAll();
    LibroEntity save(LibroEntity libro);
}