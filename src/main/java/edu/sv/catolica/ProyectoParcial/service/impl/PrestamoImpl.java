package edu.sv.catolica.ProyectoParcial.service.impl;
import edu.sv.catolica.ProyectoParcial.dto.LibroDTO;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO2;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.repository.LibroRepository;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import edu.sv.catolica.ProyectoParcial.repository.PrestamoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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
                libroRepository.findById(dto.getAutorID())
                        .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con ID: " + dto.getAutorID())));
        prestamo.setDisponible(dto.getDisponible());
        return prestamoRepository.save(prestamo);
    }























//    @Transactional
//    public PrestamoEntity actualizarPrestamo(Long id, PrestamoDTO dto) {
//        PrestamoEntity prestamo = prestamoRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Préstamo no encontrado"));
//
//        // Buscar el libro por título
//        LibroEntity libro = (LibroEntity) libroRepository.findByTitulo(dto.getTituloLibro())
//                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado"));
//
//        // Buscar el usuario por nombre
//        UsuarioEntity usuario = (UsuarioEntity) usuarioRepository.findByNombre(dto.getNombreUsuario())
//                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
//
//        prestamo.setLibroID(libro);
//        prestamo.setUsuarioID(usuario);
//        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
//
//        return prestamoRepository.save(prestamo);
//    }
//@Transactional
//public PrestamoEntity actualizarPrestamo(Long id, PrestamoDTO dto) {
//    PrestamoEntity prestamo = prestamoRepository.findById(id)
//            .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado con ID: " + id));
//    prestamo.setPrestamoID(dto.getPrestamoID());
//    prestamo.setFechaPrestamo(dto.getFechaPrestamo());
//    libro.setTitulo(dto.getTitulo());
//    libro.setAutor( (AutorEntity)
//            autorRepository.findById(dto.getAutorID())
//                    .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con ID: " + dto.getAutorID())));
//    libro.setPublicacion(Date.valueOf(dto.getPublicacion()));
//    libro.setGenero(dto.getGenero());
//    libro.setDisponible(dto.getDisponible());
//    return libroRepository.save(libro);
//}

//    @Transactional
//    public PrestamoEntity actualizarPrestamo(Long id, PrestamoDTO dto) {
//        PrestamoEntity prestamo = prestamoRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado con ID: " + id));
//
//        // Actualizamos los campos desde el DTO
//        prestamo.setPrestamoID(dto.getPrestamoID());
//        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
//
//
//        // Guardamos los cambios
//        return prestamoRepository.save(prestamo);
//    }



}