package edu.sv.catolica.ProyectoParcial.controller;
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
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(multa.findAll())
                .build(),
                HttpStatus.OK);
    }


    @Transactional
    @PostMapping("/PostMulta")
    public ResponseEntity<?> saveMultas(@RequestBody MultaEntity nuevaMulta) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(multa.save(nuevaMulta))
                .build(),
                HttpStatus.OK);

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
    public ResponseEntity<?> actualizaMulta(@PathVariable Long id, @RequestBody MultaDTO dto) {
        try {
            MultaEntity actualizado = multaImpl.actualizarMulta(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }






}