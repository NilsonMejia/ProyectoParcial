package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.dto.AutorDTO;
import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import edu.sv.catolica.ProyectoParcial.service.impl.BibliotecaImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Biblioteca")
public class BibliotecaController {
    @Autowired
    private IBiblioteca biblioteca;
    @Autowired
    private BibliotecaImpl bibliotecaImpl;

    @Transactional(readOnly = true)
    @GetMapping("/GetBiblioteca")
    public ResponseEntity<?> getAutores() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(biblioteca.findAll())
                .build(),
                HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/PostBiblioteca")
    public ResponseEntity<?> saveBiblioteca(@RequestBody BibliotecaEntity nuevaBiblioteca) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(biblioteca.save(nuevaBiblioteca))
                .build(),
                HttpStatus.OK);

    }


    @Transactional(readOnly = true)
    @GetMapping("/ConsultaFecha/{Fecha}")
    public ResponseEntity<?> findFechaDevolucion(@PathVariable("Fecha") LocalDate fechaDevolucion)
        {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Fecha de devolucion")
                .data(biblioteca.findFechaDevolucion(fechaDevolucion))
                .build(),
                HttpStatus.OK);
    }

    @PutMapping("/ActualizarBiblioteca/{id}")
    public ResponseEntity<?> actualizarBiblioteca(
            @PathVariable Long id,
            @RequestBody BibliotecaDTO dto) {
        try {
            BibliotecaEntity actualizado = bibliotecaImpl.actualizarBiblioteca(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}