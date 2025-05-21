package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IMulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import java.util.List;

@RestController
@RequestMapping("/Multa")
public class MultaController {
    @Autowired
    private IMulta multa;

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
    public MultaEntity saveMultas(@RequestBody MultaEntity nuevaMulta) {
        return multa.save(nuevaMulta);

    }

}