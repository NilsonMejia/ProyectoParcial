package edu.sv.catolica.ProyectoParcial.service.impl;

import edu.sv.catolica.ProyectoParcial.dto.LibroDTO;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO2;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.repository.MultaRepository;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;
import edu.sv.catolica.ProyectoParcial.service.IMulta;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class MultaImpl implements IMulta {

    @Autowired
    private MultaRepository multaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<MultaEntity> findAll(){

        return multaRepository.findAll();

    }
    @Override
    public MultaEntity save(MultaEntity multa) {
        return multaRepository.save(multa);
    }

    @Override
    public List<MultaDTO> findMultasMenoresA(int cantidad ) {
        return multaRepository.findMultasMenoresA(cantidad);
    }

    @Transactional
    public MultaEntity actualizarMulta(Long id, MultaDTO2 dto) {
        MultaEntity multa = multaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Multa no encontrada con ID: " + id));
        multa.setEstado(dto.getEstado());
        multa.setFechaGeneracion(dto.getFechaGeneracion());
        multa.setMonto(dto.getMonto());
        multa.setUsuario((UsuarioEntity)
                usuarioRepository.findById(dto.getUsuarioID())
                        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + dto.getUsuarioID())));
        return multaRepository.save(multa);
    }


    @Override
    public void delete(Long id) {
        if (!multaRepository.existsById(id)) {
            throw new RuntimeException("Multa no encontrada con id: " + id);
        }
        multaRepository.deleteById(id);
    }

}