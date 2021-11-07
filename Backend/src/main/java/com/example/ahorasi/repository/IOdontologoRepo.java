package com.example.ahorasi.repository;

import com.example.ahorasi.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepo extends JpaRepository<Odontologo, Long> { //definimos tipo de dato y el identificador

}
