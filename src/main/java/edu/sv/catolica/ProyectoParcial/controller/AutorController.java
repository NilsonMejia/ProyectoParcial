package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.dto.AutorDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.impl.AutorImpl;
import edu.sv.catolica.ProyectoParcial.service.impl.UsuarioImpl;
import jakarta.persistence.EntityNotFoundException;
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
    @Autowired
    private AutorImpl autorImpl;


    @Transactional(readOnly = true)
    @GetMapping("/GetAutor")
    public ResponseEntity<?> getAutores() {
        try {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Proceso realizado con éxito")
                            .data(autor.findAll())
                            .build(),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los autores")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Transactional
    @PostMapping("/PostAutor")
    public ResponseEntity<?> saveAutores(@RequestBody AutorEntity nuevoautor) {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(autor.save(nuevoautor))
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los autores")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/AutorPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AutorDTO obtenerAutor(@PathVariable("id") Long id) {
        return autor.AutorPorId(id);
    }


    @PutMapping("/ActualizarAutor/{id}")
    public ResponseEntity<?> actualizarAutor(
            @PathVariable Long id,
            @RequestBody AutorDTO dto) {
        try {
            AutorEntity actualizado = autorImpl.actualizarAutor(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
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