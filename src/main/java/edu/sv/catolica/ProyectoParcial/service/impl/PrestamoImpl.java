package edu.sv.catolica.ProyectoParcial.service.impl;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO2;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoImpl implements IPrestamo {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<PrestamoEntity> findAll(){

        return prestamoRepository.findAll();

    }
    @Override
    public PrestamoEntity save(PrestamoEntity prestamo) {
        return prestamoRepository.save(prestamo);
    }


    @Override
    public List<PrestamoDTO>obtenerPrestamosPorFecha(LocalDate fecha ) {
        return prestamoRepository.obtenerPrestamosPorFecha(fecha);
    }
    @Transactional
    public PrestamoEntity actualizarPrestamo(Long id, PrestamoDTO2 dto) {
        PrestamoEntity prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado con ID: " + id));
        prestamo.setPrestamoID(dto.getPrestamoID());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setFechaDevolucion(dto.getFechaDevolucion());
        prestamo.setLibroID((LibroEntity)
                libroRepository.findById(dto.getLibroID())
                        .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + dto.getLibroID())));
        prestamo.setDisponible(dto.getDisponible());
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void delete(Long id) {
        if (!prestamoRepository.existsById(id)) {
            throw new RuntimeException("Prestamo no encontrado con id: " + id);
        }
        prestamoRepository.deleteById(id);
    }

}