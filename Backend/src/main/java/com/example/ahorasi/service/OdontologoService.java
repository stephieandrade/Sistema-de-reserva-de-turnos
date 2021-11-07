package com.example.ahorasi.service;

import com.example.ahorasi.entities.Odontologo;
import com.example.ahorasi.entities.OdontologoDTO;
import com.example.ahorasi.repository.IOdontologoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService { //ejecuta logica de aplicacion usando repositorio

    @Autowired
    IOdontologoRepo repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Odontologo guardarOdontologo(OdontologoDTO odo) {
        Odontologo nuevoOdontologo = mapper.convertValue(odo, Odontologo.class);
        repository.save(nuevoOdontologo);
        return null;
    }

    @Override
    public Collection<OdontologoDTO> obtenerUsuarios() {
        List<Odontologo> odontologos = repository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for(Odontologo odontologo : odontologos)
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class)); //con mapper pasa el odongoloto a objeto.json
                    return odontologosDTO;
    }

    @Override
    public OdontologoDTO buscar(Long id) {
        Optional<Odontologo> found = repository.findById(id);
        return mapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Odontologo actualizar(OdontologoDTO odo) {
        Odontologo nuevoOdontologo = mapper.convertValue(odo, Odontologo.class);
        repository.save(nuevoOdontologo);
        return null;
    }
}
