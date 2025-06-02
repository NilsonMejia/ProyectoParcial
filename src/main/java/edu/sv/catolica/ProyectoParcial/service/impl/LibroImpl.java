package edu.sv.catolica.ProyectoParcial.service.impl;

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
    public void eliminarLibro(long LibroID) {
        if (!libroRepository.existsById(LibroID)) {
            throw new IllegalArgumentException("Libro no existe");
        }
        libroRepository.deleteById(LibroID);
    }
}