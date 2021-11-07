package com.example.ahorasi.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Turnos")
@Getter //agrega los getters de todos los atributos
@Setter //agrega los setters de todos los atributos
public class Turno {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //OJO CON ESTO se eliminen todos los PACIENTES en cascada
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //OJO CON ESTO se eliminen todos los PACIENTES en cascada
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    private String date;

//    @Override
//    public String toString() {
//        return "Turno{" +
//                "id=" + id +
//                ", paciente=" + paciente +
//                ", odontologo=" + odontologo +
//                ", date=" + date +
//                '}';
//    }
}
