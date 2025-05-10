package edu.sv.catolica.ProyectoParcial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.service.IAutor;
import java.util.List;

@RestController
@RequestMapping("/process")
public class AutorController {
    @Autowired
    private IAutor autor;

    @Transactional(readOnly = true)
    @GetMapping("/Autor")
    public List<AutorEntity> getAutores() {
        return autor.findAll();
    }
    @Transactional
    @PostMapping("/Autor")
    public AutorEntity saveAutores(@RequestBody AutorEntity nuevoautor) {
        return autor.save(nuevoautor);

    }

}