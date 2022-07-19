package com.codo.acodo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="preguntaformulario")
public class PreguntaFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String enunciado;
    private String tipo;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String opcion5;
    private String opcion6;
    private String opcion7;
    private String opcion8;
    private String opcion9;
    private String fechaM = new Date().toGMTString();
    ;
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<OpcionFormulario> opciones;


    @ManyToOne
    @JoinColumn(name = "fomulario")
    private Formulario formulario;

    public PreguntaFormulario() {
    }

    public PreguntaFormulario(Long id, String descripcion, String enunciado, String tipo, String opcion1, String opcion2, String opcion3, String opcion4, String opcion5, String opcion6, String opcion7, String opcion8, String opcion9, String fechaM, List<OpcionFormulario> opciones, Formulario formulario) {
        this.id = id;
        this.descripcion = descripcion;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.opcion5 = opcion5;
        this.opcion6 = opcion6;
        this.opcion7 = opcion7;
        this.opcion8 = opcion8;
        this.opcion9 = opcion9;
        this.fechaM = fechaM;
        this.opciones = opciones;
        this.formulario = formulario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    public String getOpcion6() {
        return opcion6;
    }

    public void setOpcion6(String opcion6) {
        this.opcion6 = opcion6;
    }

    public String getOpcion7() {
        return opcion7;
    }

    public void setOpcion7(String opcion7) {
        this.opcion7 = opcion7;
    }

    public String getOpcion8() {
        return opcion8;
    }

    public void setOpcion8(String opcion8) {
        this.opcion8 = opcion8;
    }

    public String getOpcion9() {
        return opcion9;
    }

    public void setOpcion9(String opcion9) {
        this.opcion9 = opcion9;
    }

    public String getFechaM() {
        return fechaM;
    }

    public void setFechaM(String fechaM) {
        this.fechaM = fechaM;
    }

    public List<OpcionFormulario> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionFormulario> opciones) {
        this.opciones = opciones;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }
}
