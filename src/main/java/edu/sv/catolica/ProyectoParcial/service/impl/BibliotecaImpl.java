package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.repository.BibliotecaRepository;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BibliotecaImpl implements IBiblioteca {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Override
    public List<BibliotecaEntity> findAll() {

        return bibliotecaRepository.findAll();

    }

    @Override
    public BibliotecaEntity save(BibliotecaEntity biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    @Override
    public List<BibliotecaDTO> findFechaDevolucion(LocalDate fechaDevolucion) {
        return bibliotecaRepository.findFechaDevolucion(fechaDevolucion);
    }
}