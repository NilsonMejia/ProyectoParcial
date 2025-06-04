package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ILibro {
    List<LibroEntity> findAll();
    LibroEntity save(LibroEntity libro);

    List<LibroEntity> buscarPorTitulo(String Titulo);



    @Transactional
    Object eliminarLibro(Long libroID);
}