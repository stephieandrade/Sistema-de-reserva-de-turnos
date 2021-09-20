package com.example.ahorasi.service;

import com.example.ahorasi.entities.Domicilio;
import com.example.ahorasi.entities.Turno;
import com.example.ahorasi.repository.TurnoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    TurnoRepo repository;

    public Turno guardar(Turno p) {
        return repository.save(p);
    }
    public Optional<Turno> buscar(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    public List<Turno> buscarTodos() {
        return repository.findAll();
    }

    public void eliminar(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

    public Turno actualizar(Turno p) {
        return repository.save(p);
    }
}
