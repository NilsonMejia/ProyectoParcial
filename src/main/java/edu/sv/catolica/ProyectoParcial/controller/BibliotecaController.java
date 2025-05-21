package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Biblioteca")
public class BibliotecaController {
    @Autowired
    private IBiblioteca biblioteca;

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
    public BibliotecaEntity saveBiblioteca(@RequestBody BibliotecaEntity nuevaBiblioteca) {
        return biblioteca.save(nuevaBiblioteca);

    }

}