package com.example.ahorasi.service;

import com.example.ahorasi.entities.Odontologo;
import com.example.ahorasi.repository.OdontologoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OdontologoService { //ejecuta logica de aplicacion usando repositorio
    @Autowired
    OdontologoRepo odontologoRepository;

    public ArrayList<Odontologo> obtenerUsuarios(){
        return (ArrayList<Odontologo>) odontologoRepository.findAll();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(Math.toIntExact(id));
    }

    public Optional<Odontologo> buscar(Long id) {
        return odontologoRepository.findById(Math.toIntExact(id));
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }



}
