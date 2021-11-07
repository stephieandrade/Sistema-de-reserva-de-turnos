package com.example.ahorasi.repository;


import com.example.ahorasi.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Long> {


}
