package com.example.ahorasi.service;

import com.example.ahorasi.entities.*;
import com.example.ahorasi.repository.IPacienteRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepo repository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    IDomicilioService domicilioService;

    public Paciente guardar(PacienteDTO p) {
        Paciente nuevoPaciente = mapper.convertValue(p, Paciente.class);

        p.getDomicilio().setId(domicilioService.guardar(p.getDomicilio()).getId());
        repository.save(nuevoPaciente);
        return null;
    }

    public PacienteDTO buscar(Long id) {
        Optional<Paciente> found = repository.findById(id);
        return mapper.convertValue(found, PacienteDTO.class);
    }

    public Collection<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = repository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for(Paciente paciente : pacientes)
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class)); //con mapper pasa el odongoloto a objeto.json
        return pacienteDTOS;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Paciente actualizar(PacienteDTO p) {
        Paciente nuevoPaciente = mapper.convertValue(p, Paciente.class);
        return repository.save(nuevoPaciente);
    }

}
