package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;

import java.util.List;

public interface IMulta {
    List<MultaEntity> findAll();
    MultaEntity save(MultaEntity multa);
}