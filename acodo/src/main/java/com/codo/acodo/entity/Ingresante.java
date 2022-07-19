package com.codo.acodo.entity;

import javax.persistence.*;

@Entity

@Table(name = "ingresante")
public class Ingresante {

    /**
     * **************Datos Duros********************************
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private Long celu;
    private String tDoc;
    private String numDoc;
    private String apellido;
    private String nombre;
    private String fNacimiento;
    private String genero;
    private String nacionalidad;
    private String pais;
    private String provincia;
    private String localidadResi;
    private String domicilio;
    private Boolean d_estado = false;
    private String password;
    private String activado="NO";

    public Ingresante() {
    }

    public Ingresante(Long id, String mail, Long celu, String tDoc, String numDoc, String apellido, String nombre, String fNacimiento, String genero, String nacionalidad, String pais, String provincia, String localidadResi, String domicilio, Boolean d_estado, String password, String activado) {
        this.id = id;
        this.mail = mail;
        this.celu = celu;
        this.tDoc = tDoc;
        this.numDoc = numDoc;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.pais = pais;
        this.provincia = provincia;
        this.localidadResi = localidadResi;
        this.domicilio = domicilio;
        this.d_estado = d_estado;
        this.password = password;
        this.activado = activado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getCelu() {
        return celu;
    }

    public void setCelu(Long celu) {
        this.celu = celu;
    }

    public String gettDoc() {
        return tDoc;
    }

    public void settDoc(String tDoc) {
        this.tDoc = tDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
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

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidadResi() {
        return localidadResi;
    }

    public void setLocalidadResi(String localidadResi) {
        this.localidadResi = localidadResi;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Boolean getD_estado() {
        return d_estado;
    }

    public void setD_estado(Boolean d_estado) {
        this.d_estado = d_estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivado() {
        return activado;
    }

    public void setActivado(String activado) {
        this.activado = activado;
    }
}