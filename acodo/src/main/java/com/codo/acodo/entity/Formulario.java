package com.codo.acodo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Table(name = "formulario")
public class Formulario {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String fechaM=new Date().toGMTString();;
    @OneToMany(mappedBy = "formulario",cascade = CascadeType.ALL)
    private List<PreguntaFormulario> preguntas=new ArrayList<>();

    public Formulario() {
    }

    public Formulario(Long id, String nombre, String fechaM, List<PreguntaFormulario> preguntas) {
        Id = id;
        this.nombre = nombre;
        this.fechaM = fechaM;
        this.preguntas = preguntas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public List<PreguntaFormulario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaFormulario> preguntas) {
        this.preguntas = preguntas;
    }
}
