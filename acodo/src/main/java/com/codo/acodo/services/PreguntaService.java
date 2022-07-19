package com.codo.acodo.services;

import com.codo.acodo.entity.Formulario;
import com.codo.acodo.entity.PreguntaFormulario;

import java.util.List;

public interface PreguntaService {
    public PreguntaFormulario savePreg(PreguntaFormulario preg);
    public void deletePreg(Long id);
    public List<PreguntaFormulario> findAllPreg();
    public List<PreguntaFormulario> findAllPregByForm(Long id);
    public PreguntaFormulario findPregById(Long id);
}
