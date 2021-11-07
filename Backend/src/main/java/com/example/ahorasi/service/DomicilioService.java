package com.example.ahorasi.service;

import com.example.ahorasi.entities.Domicilio;
import com.example.ahorasi.repository.IDomicilioRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    IDomicilioRepo repository;
    @Autowired
    ObjectMapper mapper;

    public Domicilio guardar(Domicilio p) {
        return repository.save(p);
    }
    public Optional<Domicilio> buscar(Long id) {
        Optional<Domicilio> found = repository.findById(id);
        return found;
    }

    public Collection<Domicilio> buscarTodos() {
        List<Domicilio> Domicilios = repository.findAll();
        Set<Domicilio> DomicilioDTOS = new HashSet<>();
        for(Domicilio Domicilio : Domicilios)
            DomicilioDTOS.add(Domicilio); //con mapper pasa el odongoloto a objeto.json
        return DomicilioDTOS;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Domicilio actualizar(Domicilio p) {
        return repository.save(p);
    }
}
