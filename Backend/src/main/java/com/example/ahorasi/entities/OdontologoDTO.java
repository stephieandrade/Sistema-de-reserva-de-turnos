package com.example.ahorasi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="Odontologos")
@Getter
@Setter
public class OdontologoDTO {


    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private Set<PacienteDTO> pacientes;
    private Set<TurnoDTO> turnos;




}
