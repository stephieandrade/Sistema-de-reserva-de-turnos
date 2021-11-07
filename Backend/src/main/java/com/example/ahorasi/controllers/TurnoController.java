package com.example.ahorasi.controllers;

import com.example.ahorasi.entities.Turno;
import com.example.ahorasi.entities.TurnoDTO;
import com.example.ahorasi.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping("/Turnos")
public class TurnoController {
    @Autowired
    TurnoService service;

    @PostMapping()
    public ResponseEntity<Turno> registrarTurno(@RequestBody TurnoDTO
                                                                Turno) {

        return ResponseEntity.ok(service.guardar(Turno));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id) {
        TurnoDTO Turno = service.buscar(id);

        return ResponseEntity.ok(Turno);
    }

    @PutMapping()
    public ResponseEntity<Turno> actualizar(@RequestBody TurnoDTO Turno) {
        ResponseEntity<Turno> response = null;

        if (Turno.getId() != null && service.buscar(Turno.getId()) !=null)
            response = ResponseEntity.ok(service.actualizar(Turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (service.buscar(id) != null) {
            service.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/mostrartodos")
    public Collection<TurnoDTO> buscarTodos(){
        return service.buscarTodos();
    }
}
