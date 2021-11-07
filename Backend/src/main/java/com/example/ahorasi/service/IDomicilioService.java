package com.example.ahorasi.service;

import com.example.ahorasi.entities.Domicilio;

import java.util.Collection;
import java.util.Optional;

public interface IDomicilioService {
    Domicilio guardar(Domicilio dom);
    Collection<Domicilio> buscarTodos();
    Optional<Domicilio> buscar(Long id);
    void eliminar(Long id);
    Domicilio actualizar(Domicilio dom);
}
