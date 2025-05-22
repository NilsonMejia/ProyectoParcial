package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.service.IPrestamo;
import java.util.List;

@RestController
@RequestMapping("/Prestamo")
public class PrestamoController {
    @Autowired
    private IPrestamo prestamo;

    @Transactional(readOnly = true)
    @GetMapping("/GetPrestamo")
    public ResponseEntity<?> getAutores() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(prestamo.findAll())
                .build(),
                HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/PostPrestamo")
    public PrestamoEntity savePrestamos(@RequestBody PrestamoEntity nuevoprestamo) {
        return prestamo.save(nuevoprestamo);

    }

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaPrestamos/{cantidad}")
    public List<PrestamoDTO>obtenerTop5UsuariosConMasPrestamos(@PathVariable("cantidad") double cantidad){
        return prestamo.obtenerTop5UsuariosConMasPrestamos(cantidad);
    }



}
