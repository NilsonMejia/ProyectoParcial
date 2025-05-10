package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.repository.BibliotecaRepository;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import edu.sv.catolica.ProyectoParcial.repository.AutorRepository;
import java.util.List;

@Service
public class BibliotecaImpl implements IBiblioteca {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Override
    public List<BibliotecaEntity> findAll(){

        return bibliotecaRepository.findAll();

    }
    @Override
    public BibliotecaEntity save(BibliotecaEntity biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }
}