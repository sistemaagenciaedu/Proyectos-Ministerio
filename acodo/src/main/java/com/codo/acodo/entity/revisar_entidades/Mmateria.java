package com.codo.acodo.entity.revisar_entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mmateria")
public class Mmateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer cantPreguntas;
    @OneToMany(mappedBy = "mmateria")
    private List<Mpregunta> preguntas=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "mexamen" )
    private Mexamen mexamen;

    public Mmateria() {
    }

    public Mmateria(Long id, String nombre, Integer cantPreguntas, List<Mpregunta> preguntas, Mexamen mexamen) {
        this.id = id;
        this.nombre = nombre;
        this.cantPreguntas = cantPreguntas;
        this.preguntas = preguntas;
        this.mexamen = mexamen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(Integer cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    public List<Mpregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Mpregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Mexamen getMexamen() {
        return mexamen;
    }

    public void setMexamen(Mexamen mexamen) {
        this.mexamen = mexamen;
    }

    @Override
    public String toString() {
        return "Mmateria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantPreguntas=" + cantPreguntas +
                ", preguntas=" + preguntas +
                '}';
    }
}
