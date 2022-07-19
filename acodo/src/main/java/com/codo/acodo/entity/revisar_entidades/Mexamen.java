package com.codo.acodo.entity.revisar_entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="modeloexamen")
public class Mexamen {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long id;
   private  String titulo;
   private Integer calificacion=0;
   @OneToMany(mappedBy = "mexamen",cascade = CascadeType.ALL)
   private List<Mmateria> materias=new ArrayList<>();

   public Mexamen() {
   }

   public Mexamen(Long id, String titulo, Integer calificacion, List<Mmateria> materias) {
      this.id = id;
      this.titulo = titulo;
      this.calificacion = calificacion;
      this.materias = materias;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public Integer getCalificacion() {
      return calificacion;
   }

   public void setCalificacion(Integer calificacion) {
      this.calificacion = calificacion;
   }

   public List<Mmateria> getMaterias() {
      return materias;
   }

   public void setMaterias(List<Mmateria> materias) {
      this.materias = materias;
   }

   @Override
   public String toString() {
      return "Mexamen{" +
              "id=" + id +
              ", titulo='" + titulo + '\'' +
              ", calificacion=" + calificacion +
              ", materias=" + materias +
              '}';
   }
}
