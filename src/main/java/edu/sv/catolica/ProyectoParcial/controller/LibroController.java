package edu.sv.catolica.ProyectoParcial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import java.util.List;

@RestController
@RequestMapping("/process")
public class LibroController {
    @Autowired
    private ILibro libro;

    @Transactional(readOnly = true)
    @GetMapping("/Libro")
    public List<LibroEntity> getLibros() {
        return libro.findAll();
    }
    @Transactional
    @PostMapping("/Libro")
    public LibroEntity saveLibros(@RequestBody LibroEntity nuevolibro) {
        return libro.save(nuevolibro);

    }

}