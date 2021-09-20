package com.example.ahorasi.service;

import com.example.ahorasi.entities.Paciente;
import com.example.ahorasi.repository.PacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    PacienteRepo repository;



    public Paciente guardar(Paciente p) {
        p.setFechaIngreso(new Date());
        return repository.save(p);
    }

    public Optional<Paciente> buscar(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    public List<Paciente> buscarTodos() {
        return repository.findAll();
    }

    public void eliminar(Long id) {
        repository.deleteById(Math.toIntExact(id));
    }

    public Paciente actualizar(Paciente p) {
        return repository.save(p);
    }

}
