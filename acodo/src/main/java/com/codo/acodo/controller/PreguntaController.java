package com.codo.acodo.controller;

import com.codo.acodo.entity.Formulario;
import com.codo.acodo.entity.PreguntaFormulario;
import com.codo.acodo.services.FormularioService;
import com.codo.acodo.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

@RequestMapping("/pregunta")
public class PreguntaController {




        @Autowired
        private PreguntaService ps;
        @GetMapping("/list")
        public String listar(Long id,Model model){
            model.addAttribute("preguntas",ps.findAllPregByForm(id));
            model.addAttribute("preg",new PreguntaFormulario());
            model.addAttribute("idFormu",id);
            return "crear-pregunta";
        }

        @PostMapping("/save")
        public String saveForm(PreguntaFormulario preg,Long idForm, Model model){
            ps.savePreg(preg);
            model.addAttribute("preguntas",ps.findAllPregByForm(idForm));
            model.addAttribute("preg",new PreguntaFormulario());
            return "crear-pregunta";
        }

        @GetMapping("/delete")
        public String saveForm(Long id,Long idForm, Model model){
           ps.deletePreg(id);
            model.addAttribute("preguntas",ps.findAllPregByForm(idForm));
            model.addAttribute("preg",new PreguntaFormulario());
            return "crear-pregunta";
        }


}
