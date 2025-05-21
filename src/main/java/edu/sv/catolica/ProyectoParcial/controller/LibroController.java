package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import java.util.List;

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
    public LibroEntity saveLibros(@RequestBody LibroEntity nuevolibro) {
        return libro.save(nuevolibro);

    }

}