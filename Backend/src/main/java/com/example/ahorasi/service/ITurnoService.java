package com.example.ahorasi.service;

import com.example.ahorasi.entities.*;

import java.util.Collection;

public interface ITurnoService {
    Turno guardar(TurnoDTO tur);
    Collection<TurnoDTO> buscarTodos();
    <Optional>TurnoDTO buscar(Long id);
   void eliminar(Long id);
    Turno actualizar(TurnoDTO odo);
}
