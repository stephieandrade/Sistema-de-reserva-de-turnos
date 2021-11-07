package com.example.ahorasi.repository;

import com.example.ahorasi.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepo extends JpaRepository<Turno, Long> {
}
