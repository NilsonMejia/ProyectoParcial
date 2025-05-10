package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.repository.MultaRepository;
import edu.sv.catolica.ProyectoParcial.service.IMulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;
import java.util.List;

@Service
public class MultaImpl implements IMulta {

    @Autowired
    private MultaRepository multaRepository;

    @Override
    public List<MultaEntity> findAll(){

        return multaRepository.findAll();

    }
    @Override
    public MultaEntity save(MultaEntity multa) {
        return multaRepository.save(multa);
    }
}