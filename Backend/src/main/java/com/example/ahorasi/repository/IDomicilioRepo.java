package com.example.ahorasi.repository;

import com.example.ahorasi.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepo extends JpaRepository<Domicilio, Long> {
}
