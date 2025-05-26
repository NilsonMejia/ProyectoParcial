package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import java.util.List;

@RestController
@RequestMapping("/Autor")
public class AutorController {
    @Autowired
    private IAutor autor;

    @Transactional(readOnly = true)
    @GetMapping("/GetAutor")
    public ResponseEntity<?> getAutores() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(autor.findAll())
                .build(),
                HttpStatus.OK);
    }
/*
    @Transactional
    @PostMapping("/PostAutor")
    public AutorEntity saveAutores(@RequestBody AutorEntity nuevoautor) {
        return autor.save(nuevoautor);

    }

 */
    @Transactional
    @PostMapping("/PostAutor")
    public ResponseEntity<?> saveAutores(@RequestBody AutorEntity nuevoautor) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(autor.save(nuevoautor))
                .build(),
                HttpStatus.OK);

    }



}