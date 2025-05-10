package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import java.util.List;

public interface IAutor {
    List<AutorEntity> findAll();
    AutorEntity save(AutorEntity autor);
}