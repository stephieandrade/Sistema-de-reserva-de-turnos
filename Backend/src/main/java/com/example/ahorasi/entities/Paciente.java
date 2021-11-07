package com.example.ahorasi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="Pacientes")
@Getter //agrega los getters de todos los atributos
@Setter //agrega los setters de todos los atributos

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    @JsonIgnore //para que ignore la serializacion del json
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id" , referencedColumnName = "id")
    private Domicilio domicilio;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //se eliminen todos los PACIENTES en cascada
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @OneToMany (mappedBy = "paciente", fetch = FetchType.EAGER )
    private Set<Turno> turnos = new HashSet<>();

//    @Override
//    public String toString() {
//        return "Paciente{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", dni='" + dni + '\'' +
//                ", fechaIngreso=" + fechaIngreso +
//                ", domicilio=" + domicilio +
//                '}';
//    }
}
