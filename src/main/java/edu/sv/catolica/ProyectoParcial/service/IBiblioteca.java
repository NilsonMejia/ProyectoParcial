package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;

import java.util.List;

public interface IBiblioteca {
    List<BibliotecaEntity> findAll();
    BibliotecaEntity save(BibliotecaEntity biblioteca);
}