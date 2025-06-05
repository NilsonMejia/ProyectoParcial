package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO2;
import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO2;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IMulta;
import edu.sv.catolica.ProyectoParcial.service.impl.MultaImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Multa")
public class MultaController {
    @Autowired
    private IMulta multa;
    @Autowired
    private MultaImpl multaImpl;


    @Transactional(readOnly = true)
    @GetMapping("/GetMulta")
    public ResponseEntity<?> getAutores() {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(multa.findAll())
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los prestamos")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @Transactional
    @PostMapping("/PostMulta")
    public ResponseEntity<?> saveMultas(@RequestBody MultaEntity nuevaMulta) {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(multa.save(nuevaMulta))
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los prestamos")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaMonto/{cantidad}")
    public ResponseEntity<?>findMultasMenoresA(@PathVariable("cantidad") int cantidad){
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(multa.findMultasMenoresA(cantidad)).
                build(),
                HttpStatus.OK);
    }

    @PutMapping("/ActualizarMulta/{id}")
    public ResponseEntity<?> actualizaMulta(@PathVariable Long id, @RequestBody MultaDTO2 dto) {
        try {
            MultaEntity actualizado = multaImpl.actualizarMulta(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Transactional
    @DeleteMapping("/EliminarMulta/{id}")
    public ResponseEntity<?> eliminarMulta(@PathVariable Long id) {
        multa.delete(id);
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Multa eliminada con éxito.")
                .data("La multa con id: " + id + " ha sido eliminada")
                .build(), HttpStatus.OK);
    }






}