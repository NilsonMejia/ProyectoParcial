package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.service.IBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class BibliotecaController {
    @Autowired
    private IBiblioteca biblioteca;

    @Transactional(readOnly = true)
    @GetMapping("/Biblioteca")
    public List<BibliotecaEntity> getBiblioteca() {
        return biblioteca.findAll();
    }
    @Transactional
    @PostMapping("/Biblioteca")
    public BibliotecaEntity saveBiblioteca(@RequestBody BibliotecaEntity nuevaBiblioteca) {
        return biblioteca.save(nuevaBiblioteca);

    }

}