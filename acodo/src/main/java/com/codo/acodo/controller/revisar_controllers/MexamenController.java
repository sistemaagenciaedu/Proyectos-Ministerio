package com.codo.acodo.controller.revisar_controllers;

import com.codo.acodo.entity.revisar_entidades.Mexamen;
import com.codo.acodo.repository.revisar_repositorios.MexameneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/examen")
public class MexamenController {
    @Autowired
    private MexameneRepository mer;

    @GetMapping
    @RequestMapping("")
    public String inicio(){

        return "index";
    }

    @GetMapping
    @RequestMapping("/add")
    public String agregarExamen(Model model){

        return "agregar-examen";
    }


    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity guardarExamen(Mexamen mexamen){
        System.out.println("entro al guardado");
        if (mexamen.getId()==null){
            mexamen.setId(null);
        }
        System.out.printf(mexamen.getTitulo());
        mer.save(mexamen);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity eliminarExamen(Model model, @RequestParam(required = false, name = "id") Long id) throws Exception {
       try {
          mer.deleteById(id);
          return ResponseEntity.ok(HttpStatus.OK);
       }catch (Exception e){
           throw new Exception();
       }

    }




    @GetMapping
    @RequestMapping( "/listaexamenes")
    public String refreshlistaexa(Model model) {
        List<Mexamen> itemList = mer.findAll();

        model.addAttribute("examenes", itemList);

        return "plantilla-examen :: listaExamenes";
    }

    @GetMapping
    @RequestMapping( "/formularioexamen")
    public String refreshformex(Model model,@RequestParam(required = false, name = "id") Long id) {
        Mexamen exa=new Mexamen();

        if (id!=null){
            exa=mer.findById(id).orElse(null);
        }

        model.addAttribute("mex",exa);

        return "plantilla-examen :: agregar_editar_examen";
    }

}
