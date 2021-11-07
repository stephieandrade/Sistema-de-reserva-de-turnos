package com.example.ahorasi.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@CrossOrigin("*")
@Entity
@Table(name="Odontologos")
@Getter //agrega los getters de todos los atributos
@Setter //agrega los setters de todos los atributos
public class Odontologo {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    @OneToMany (mappedBy = "odontologo", fetch = FetchType.LAZY )
    private Set<Paciente> pacientes = new HashSet<>();
    @OneToMany (mappedBy = "odontologo", fetch = FetchType.LAZY )
    private Set<Turno> turnos = new HashSet<>();

   // public Long getId() {
   //     return id;
    //}



//    @Override
//    public String toString() {
//        return "Odontologo{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", matricula=" + matricula +
//                '}';
//    }
}
