package edu.sv.catolica.ProyectoParcial.controller;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.service.IMulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.service.ILibro;
import java.util.List;

@RestController
@RequestMapping("/process")
public class MultaController {
    @Autowired
    private IMulta multa;

    @Transactional(readOnly = true)
    @GetMapping("/Multa")
    public List<MultaEntity> getMultas() {
        return multa.findAll();
    }
    @Transactional
    @PostMapping("/Multa")
    public MultaEntity saveMultas(@RequestBody MultaEntity nuevaMulta) {
        return multa.save(nuevaMulta);

    }

}