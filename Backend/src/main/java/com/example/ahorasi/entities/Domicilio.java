package com.example.ahorasi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.ConstructorParameters;
import javax.persistence.*;
@Entity
@Table(name="Domicilios")
 //agrega los getters de todos los atributos
 //agrega los setters de todos los atributos
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private Long id;
    @Getter
    @Setter
    private String calle;
    @Getter
    @Setter
    private String numero;
    @Getter
    @Setter
    private String localidad;
    @Getter
    @Setter
    private String provincia;

    //@OneToOne(fetch = FetchType.EAGER)
   // @JoinColumn(name = "paciente_id")
   // private Paciente paciente;

//    @Override
//    public String toString() {
//        return "Domicilio{" +
//                "id=" + id +
//                ", calle='" + calle + '\'' +
//                ", numero='" + numero + '\'' +
//                ", localidad='" + localidad + '\'' +
//                ", provincia='" + provincia + '\'' +
//                '}';
//    }
}
