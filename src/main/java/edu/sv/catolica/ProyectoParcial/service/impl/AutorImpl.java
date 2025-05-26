package edu.sv.catolica.ProyectoParcial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import edu.sv.catolica.ProyectoParcial.repository.AutorRepository;

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
    public String NombrePorId(Long id){
        return autorRepository.findById(id)
                .map(AutorEntity::getNombre)
                .orElseThrow(() -> new RuntimeException("No se encontro el autor con el id: " + id));
    }
}