package edu.sv.catolica.ProyectoParcial.service.impl;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import edu.sv.catolica.ProyectoParcial.repository.AutorRepository;
import edu.sv.catolica.ProyectoParcial.dto.AutorDTO; // <-- Este import falta

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

    @Override
    public void delete(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado con id: " + id);
        }
        autorRepository.deleteById(id);
    }
}