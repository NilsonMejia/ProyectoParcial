package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import java.util.List;

@RestController
@RequestMapping("/process")
public class PrestamoController {
    @Autowired
    private IPrestamo prestamo;

    @Transactional(readOnly = true)
    @GetMapping("/Prestamo")
    public List<PrestamoEntity> getPrestamos() {
        return prestamo.findAll();
    }

    @Transactional
    @PostMapping("/Prestamo")
    public PrestamoEntity savePrestamos(@RequestBody PrestamoEntity nuevoprestamo) {
        return prestamo.save(nuevoprestamo);

    }
}
