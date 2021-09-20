package com.example.ahorasi.service;

import com.example.ahorasi.entities.Domicilio;
import com.example.ahorasi.entities.Paciente;
import com.example.ahorasi.repository.DomicilioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    @Autowired
    DomicilioRepo repository;

    public Domicilio guardar(Domicilio p) {
        return repository.save(p);
    }
    public Optional<Domicilio> buscar(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    public List<Domicilio> buscarTodos() {
        return repository.findAll();
    }

    public void eliminar(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

    public Domicilio actualizar(Domicilio p) {
        return repository.save(p);
    }
}