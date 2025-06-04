package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO2;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.repository.BibliotecaRepository;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BibliotecaImpl implements IBiblioteca {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;

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

    @Transactional
    public BibliotecaEntity actualizarBiblioteca(Long id, BibliotecaDTO dto) {
        BibliotecaEntity biblioteca = bibliotecaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Biblioteca no encontrada con ID: " + id));
        biblioteca.setBibliotecaID(dto.getBibliotecaID());
        biblioteca.setLibro((LibroEntity)
                libroRepository.findById(dto.getLibroID())
                        .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + dto.getLibroID())));
        biblioteca.setDisponible(dto.getDisponible());
        biblioteca.setPrestamo((PrestamoEntity)
                prestamoRepository.findById(dto.getPrestamoID())
                        .orElseThrow(() -> new EntityNotFoundException("Prestammo no encontrado con ID: " + dto.getPrestamoID())));
        biblioteca.setFechaDevolucion(dto.getFechaDevolucion());
        return bibliotecaRepository.save(biblioteca);
    }
}