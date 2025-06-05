package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO2;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import edu.sv.catolica.ProyectoParcial.service.impl.PrestamoImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Prestamo")
public class PrestamoController {
    @Autowired
    private IPrestamo prestamo;


    @Autowired
    private PrestamoImpl prestamoImpl;

    @Transactional(readOnly = true)
    @GetMapping("/GetPrestamo")
    public ResponseEntity<?> getAutores() {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(prestamo.findAll())
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los prestamos")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Transactional
    @PostMapping("/PostPrestamo")
    public ResponseEntity<?> savePrestamos(@RequestBody PrestamoEntity nuevoprestamo) {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(prestamo.save(nuevoprestamo))
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al enviar los datos")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaPrestamos/{fecha}")
    public ResponseEntity<?> obtenerPrestamosPorFecha(@PathVariable("fecha") LocalDate fecha) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(prestamo.obtenerPrestamosPorFecha(fecha))
                .build(),
                HttpStatus.OK);
    }

    @PutMapping("/ActualizarPrestamo/{id}")
    public ResponseEntity<?> actualizarPrestamo(@PathVariable Long id, @RequestBody PrestamoDTO2 dto) {
        try {
            PrestamoEntity actualizado = prestamoImpl.actualizarPrestamo(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @Transactional
    @DeleteMapping("/EliminarPrestamo/{id}")
    public ResponseEntity<?> eliminarPrestamo(@PathVariable Long id) {
        prestamo.delete(id);
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Presramo eliminado con éxito.")
                .data("El prestamo con id: " + id + " ha sido eliminada")
                .build(), HttpStatus.OK);
    }






}
