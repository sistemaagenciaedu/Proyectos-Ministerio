package com.codo.acodo.services;

import com.codo.acodo.entity.PreguntaFormulario;
import com.codo.acodo.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PreguntaServiceIMPL implements PreguntaService{
    @Autowired
    private PreguntaRepository pr;
    @Override
    public PreguntaFormulario savePreg(PreguntaFormulario preg) {
        return pr.save(preg);
    }

    @Override
    public void deletePreg(Long id) {
pr.deleteById(id);
    }

    @Override
    public List<PreguntaFormulario> findAllPreg() {
        return (List<PreguntaFormulario>) pr.findAll();
    }

    @Override
    public List<PreguntaFormulario> findAllPregByForm(Long id) {
       List<PreguntaFormulario> lista=new ArrayList<>();
        for (PreguntaFormulario p: findAllPreg()) {
            if(p.getFormulario().getId()==id){
                lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public PreguntaFormulario findPregById(Long id) {
        return pr.findById(id).orElse(null);
    }
}
