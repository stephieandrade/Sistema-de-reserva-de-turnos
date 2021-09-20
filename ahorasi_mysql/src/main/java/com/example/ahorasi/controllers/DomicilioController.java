package com.example.ahorasi.controllers;

import com.example.ahorasi.entities.Domicilio;
import com.example.ahorasi.entities.Paciente;
import com.example.ahorasi.repository.DomicilioRepo;
import com.example.ahorasi.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @PostMapping()
    public ResponseEntity<Domicilio> registrarDomicilio(@RequestBody Domicilio
                                                                    domicilio) {

        return ResponseEntity.ok(service.guardar(domicilio));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscar(@PathVariable Long id) {
        Domicilio domicilio = service.buscar(id).orElse(null);

        return ResponseEntity.ok(domicilio);
    }

    @PutMapping()
    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
        ResponseEntity<Domicilio> response = null;

        if (domicilio.getId() != null && service.buscar(domicilio.getId()).isPresent())
            response = ResponseEntity.ok(service.actualizar(domicilio));
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
    public List<Domicilio> buscarTodos(){
        return service.buscarTodos();
    }
}
