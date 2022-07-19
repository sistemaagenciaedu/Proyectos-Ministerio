package com.codo.acodo.services;

import com.codo.acodo.entity.Ingresante;

import java.util.List;

public interface IngresanteService {
    public Ingresante crearIngresante(Ingresante ingresante, Ingresante ingresanteModificado);
    public List<Ingresante> devolverListaParaImportar(List<Ingresante> lista);
    public Ingresante createIngresante(Ingresante ingresante);
    public List<Ingresante> findAllIngresante();
    public Ingresante saveIngresante(Ingresante ingresante);
    public void deleteIngresante(Ingresante ingresante);
    public Ingresante findIngresante(Ingresante ingresante);
    public Ingresante findIngresanteById(Long id);
    public Ingresante findIngresanteByDoc(String numDoc);
    public Ingresante guardarDDuros(Ingresante ingresante);
    public Ingresante guardarEncuenta(Ingresante ingresante);
    public Ingresante guardarNivel(Ingresante ingresante,String i_uso_t_situacion_otro,String i_donde_otro);
    //public List<Ingresante>buscadorUniversal(String query);
    public List<Ingresante>getByFilter(String query, String desde, String hasta, String genero, String encuenta, String examen,String order);

}
