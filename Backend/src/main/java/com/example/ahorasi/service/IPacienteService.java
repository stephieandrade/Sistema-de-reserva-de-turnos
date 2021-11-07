package com.example.ahorasi.service;

import com.example.ahorasi.entities.Odontologo;
import com.example.ahorasi.entities.OdontologoDTO;
import com.example.ahorasi.entities.Paciente;
import com.example.ahorasi.entities.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {
    Paciente guardar(PacienteDTO pac);
    Collection<PacienteDTO> buscarTodos();
    PacienteDTO buscar(Long id);
    void eliminar(Long id);
    Paciente actualizar(PacienteDTO odo);
}
