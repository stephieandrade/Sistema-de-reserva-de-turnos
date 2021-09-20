package com.example.ahorasi.controllers;

import com.example.ahorasi.entities.Turno;
import com.example.ahorasi.service.TurnoService;
import com.example.ahorasi.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService service;

    @PostMapping()
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno
                                                                Turno) {

        return ResponseEntity.ok(service.guardar(Turno));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id) {
        Turno Turno = service.buscar(id).orElse(null);

        return ResponseEntity.ok(Turno);
    }

    @PutMapping()
    public ResponseEntity<Turno> actualizar(@RequestBody Turno Turno) {
        ResponseEntity<Turno> response = null;

        if (Turno.getId() != null && service.buscar(Turno.getId()).isPresent())
            response = ResponseEntity.ok(service.actualizar(Turno));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (service.buscar(id).isPresent()) {
            service.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public List<Turno> buscarTodos(){
        return service.buscarTodos();
    }
}
