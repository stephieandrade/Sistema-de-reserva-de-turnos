package com.example.ahorasi.service;

import com.example.ahorasi.entities.*;
import com.example.ahorasi.entities.Turno;
import com.example.ahorasi.repository.ITurnoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    ITurnoRepo repository;
    
    @Autowired
    ObjectMapper mapper;


    public Turno guardar(TurnoDTO p) {
        Turno nuevoTurno = mapper.convertValue(p, Turno.class);
        repository.save(nuevoTurno);
        return null;
    }
    
    public TurnoDTO buscar(Long id) {
        Optional<Turno> found = repository.findById(id);
        return mapper.convertValue(found, TurnoDTO.class);
    }

    public Collection<TurnoDTO> buscarTodos() {
        List<Turno> Turnos = repository.findAll();
        Set<TurnoDTO> TurnoDTOS = new HashSet<>();
        for(Turno Turno : Turnos)
            TurnoDTOS.add(mapper.convertValue(Turno, TurnoDTO.class)); //con mapper pasa el odongoloto a objeto.json
        return TurnoDTOS;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Turno actualizar(TurnoDTO p) {
        Turno nuevoTurno = mapper.convertValue(p, Turno.class);
        repository.save(nuevoTurno);
        return null;
    }
}
