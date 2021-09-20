package com.example.ahorasi.repository;

import com.example.ahorasi.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepo extends JpaRepository<Odontologo, Integer> { //definimos tipo de dato y el identificador

}
