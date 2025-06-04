package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.repository.BibliotecaRepository;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;
import java.util.List;

@Service
public class LibroImpl implements ILibro {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;

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


}