package com.codo.acodo.entity;

import javax.persistence.*;

@Entity
@Table(name="opcionformulario")
public class OpcionFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "pregunta" )
    private PreguntaFormulario pregunta;


}
