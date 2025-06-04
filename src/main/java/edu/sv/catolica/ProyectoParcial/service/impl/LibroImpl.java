package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.dto.LibroDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.repository.AutorRepository;
import edu.sv.catolica.ProyectoParcial.repository.BibliotecaRepository;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;

import java.sql.Date;
import java.util.List;

@Service
public class LibroImpl implements ILibro {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<LibroEntity> findAll(){

        return libroRepository.findAll();

    }
    @Override
    public LibroEntity save(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<LibroEntity> buscarPorTitulo(String Titulo) {
        return libroRepository.buscarPorTitulo(Titulo);
    }

    @Transactional
    public Object eliminarLibro(Long libroId) {
        // 1. Buscar el libro
        LibroEntity libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // 2. Eliminar todas las bibliotecas asociadas a préstamos de este libro
        bibliotecaRepository.deleteByPrestamoLibro(libro);

        // 3. Eliminar todos los préstamos del libro
        prestamoRepository.deleteByLibro(libro);

        // 4. Finalmente eliminar el libro
        libroRepository.delete(libro);
        return null;
    }

    @Transactional
    public LibroEntity actualizarLibro(Long id, LibroDTO dto) {
        LibroEntity libro = libroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + id));
        libro.setLibroID(dto.getLibroID());
        libro.setTitulo(dto.getTitulo());
        libro.setAutor( (AutorEntity)
                autorRepository.findById(dto.getAutorID())
                        .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con ID: " + dto.getAutorID())));
        libro.setPublicacion(Date.valueOf(dto.getPublicacion()));
        libro.setGenero(dto.getGenero());
        libro.setDisponible(dto.getDisponible());
        return libroRepository.save(libro);
    }

}