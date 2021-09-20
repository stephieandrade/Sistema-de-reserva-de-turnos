package com.example.ahorasi.repository;


import com.example.ahorasi.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepo extends JpaRepository<Paciente, Integer> {


}
