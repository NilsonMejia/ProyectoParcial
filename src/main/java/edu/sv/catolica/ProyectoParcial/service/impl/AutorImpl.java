package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import edu.sv.catolica.ProyectoParcial.repository.AutorRepository;
import edu.sv.catolica.ProyectoParcial.dto.AutorDTO; // <-- Este import falta
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorImpl implements IAutor {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorEntity> findAll(){

        return autorRepository.findAll();

    }

    @Override
    public AutorEntity save(AutorEntity autor) {
        return autorRepository.save(autor);
    }

    @Override
    public AutorDTO AutorPorId(Long id) {
        return autorRepository.AutorPorId(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Transactional
    public AutorEntity actualizarAutor(Long id, AutorDTO dto) {
        AutorEntity autor = autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con ID: " + id));
        autor.setAutorID(dto.getAutorID());
        autor.setNombre(dto.getNombre());
        autor.setApellido(dto.getApellido());
        return autorRepository.save(autor);
    }

    @Override
    public void delete(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado con id: " + id);
        }
        autorRepository.deleteById(id);
    }
}