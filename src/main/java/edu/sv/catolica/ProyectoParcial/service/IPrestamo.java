package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import java.util.List;

public interface IPrestamo {
    List<PrestamoEntity> findAll();
    PrestamoEntity save(PrestamoEntity prestamo);
}