package edu.sv.catolica.ProyectoParcial.service.impl;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;

import java.util.List;

@Service
public class PrestamoImpl implements IPrestamo {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<PrestamoEntity> findAll(){

        return prestamoRepository.findAll();

    }
    @Override
    public PrestamoEntity save(PrestamoEntity prestamo) {
        return prestamoRepository.save(prestamo);
    }
}