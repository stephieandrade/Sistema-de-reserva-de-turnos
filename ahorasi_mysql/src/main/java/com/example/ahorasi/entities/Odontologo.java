package com.example.ahorasi.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Odontologo {
    @Id
    private Long id;
    @SequenceGenerator(name = "odontologos_sequence", sequenceName = "odontologos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologos_sequence")

    private String nombre;
    private String apellido;
    private Integer matricula;
    @OneToMany (mappedBy = "odontologo", fetch = FetchType.LAZY )
    private Set<Paciente> pacientes = new HashSet<>();

    @OneToMany (mappedBy = "odontologo", fetch = FetchType.LAZY )
    private Set<Turno> turnos = new HashSet<>();

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public Odontologo() {
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
