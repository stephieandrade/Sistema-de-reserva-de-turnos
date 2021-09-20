package com.example.ahorasi.controllers;

import com.example.ahorasi.entities.Odontologo;
import com.example.ahorasi.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController { //recibe peticion web y manda a llamar un servicio
        @Autowired
        OdontologoService odontologoService;

    @GetMapping
    public ArrayList<Odontologo> obtenerUsuarios(){
        return odontologoService.obtenerUsuarios();
    }

    @PostMapping
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){
        return this.odontologoService.guardarOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscar(id).isPresent()) {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscar(id).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }







}
