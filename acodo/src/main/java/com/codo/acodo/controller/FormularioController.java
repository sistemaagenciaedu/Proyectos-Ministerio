package com.codo.acodo.controller;

import com.codo.acodo.entity.Formulario;
import com.codo.acodo.services.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/formulario")
public class FormularioController {
    @Autowired
    private FormularioService fs;
@GetMapping("/list")
public String listar(Model model){
    model.addAttribute("formularios",fs.findAllForms());
    model.addAttribute("formu",new Formulario());
    return "crear-formulario";
}

    @PostMapping("/save")
    public String saveForm(Formulario form, Model model){
        fs.saveForm(form);
        model.addAttribute("formularios",fs.findAllForms());
        model.addAttribute("formu",new Formulario());
        return "crear-formulario";
    }

    @GetMapping("/delete")
    public String saveForm(Long id, Model model){
       fs.deleteForm(id);
        model.addAttribute("formularios",fs.findAllForms());
        model.addAttribute("formu",new Formulario());
        return "crear-formulario";
    }
}
