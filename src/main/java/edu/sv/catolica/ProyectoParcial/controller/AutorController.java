package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.dto.AutorDTO;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import org.springframework.http.MediaType;
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
    @Transactional
    @PostMapping("/PostAutor")
    public ResponseEntity<?> saveAutores(@RequestBody AutorEntity nuevoautor) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(autor.save(nuevoautor))
                .build(),
                HttpStatus.OK);

    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/AutorPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AutorDTO obtenerAutor(@PathVariable("id") Long id) {
        return autor.AutorPorId(id);
    }

    @Transactional
    @DeleteMapping("/AutorEliminar/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable Long id) {
        autor.delete(id);
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Autor eliminado con éxito.")
                .build(), HttpStatus.OK);
    }
}