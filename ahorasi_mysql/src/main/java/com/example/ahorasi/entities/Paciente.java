package com.example.ahorasi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private Date fechaIngreso;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Domicilio domicilio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //se eliminen todos los PACIENTES en cascada
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @OneToMany (mappedBy = "paciente", fetch = FetchType.LAZY )
    private Set<Turno> turnos = new HashSet<>();

    public Paciente() { //sin odontologo no hay paciente
    }

    public Long getId() {//getter de id si, setter NO
        return id;
    }


    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }
}
