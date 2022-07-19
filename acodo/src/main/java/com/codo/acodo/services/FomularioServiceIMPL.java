package com.codo.acodo.services;

import com.codo.acodo.entity.Formulario;
import com.codo.acodo.repository.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FomularioServiceIMPL implements FormularioService{
    @Autowired
    private FormularioRepository fr;
    @Override
    public Formulario saveForm(Formulario form) {

        return fr.save(form);
    }

    @Override
    public void deleteForm(Long id) {
     fr.delete(findFormById(id));
    }

    @Override
    public List<Formulario> findAllForms() {

        return (List <Formulario>)fr.findAll();
    }

    @Override
    public Formulario findFormById(Long id) {
        return fr.findById(id).orElse(null);
    }
}
