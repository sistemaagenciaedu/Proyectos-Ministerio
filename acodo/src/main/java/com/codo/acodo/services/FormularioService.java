package com.codo.acodo.services;



import com.codo.acodo.entity.Formulario;

import java.util.List;

public interface FormularioService {

   public Formulario saveForm(Formulario form);
   public void deleteForm(Long id);
   public  List<Formulario> findAllForms();
    public  Formulario findFormById(Long Id);

}
