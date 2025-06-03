package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.impl.LibroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Libro")
public class LibroController {
    @Autowired
    private ILibro libro;

    @Transactional(readOnly = true)
    @GetMapping("/GetLibro")
    public ResponseEntity<?> getAutores() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(libro.findAll())
                .build(),
                HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/PostLibro")
    public ResponseEntity<?> saveLibros(@RequestBody LibroEntity nuevolibro) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(libro.save(nuevolibro))
                .build(),
                 HttpStatus.OK);

    }
    @Transactional(readOnly = true)
    @GetMapping("/BuscarLibro/{Titulo}")
    public ResponseEntity<?> buscarLibroPorTitulo(@PathVariable String Titulo) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Libros encontrados")
                .data(libro.buscarPorTitulo(Titulo))
                .build(),
                HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{libroID}")
//    public ResponseEntity<?> eliminarLibro(@PathVariable Long libroID) {
//        libro.eliminarLibro(libroID);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping("/delete/{libroID}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Long libroID) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Libro Eliminado")
                .data(libro.eliminarLibro(libroID))
                .build(),
                HttpStatus.OK);
    }
}