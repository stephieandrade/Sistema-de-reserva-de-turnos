package com.example.ahorasi.controllers;

import com.example.ahorasi.entities.Paciente;
import com.example.ahorasi.entities.PacienteDTO;
import com.example.ahorasi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping("/Pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody PacienteDTO paciente) {

        return ResponseEntity.ok(pacienteService.guardar(paciente));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id) {
        PacienteDTO paciente = pacienteService.buscar(id);

        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/")
    public ResponseEntity<Paciente> actualizar(@RequestBody PacienteDTO paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscar(paciente.getId())!= null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscar(id).getId() != null) { //FUNCIONA??????
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/mostrartodos")
    public Collection<PacienteDTO> buscarTodos(){
        return pacienteService.buscarTodos();
    }


}
