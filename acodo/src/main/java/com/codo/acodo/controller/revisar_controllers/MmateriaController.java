package com.codo.acodo.controller.revisar_controllers;

import com.codo.acodo.entity.revisar_entidades.Mexamen;
import com.codo.acodo.entity.revisar_entidades.Mmateria;
import com.codo.acodo.repository.revisar_repositorios.MexameneRepository;
import com.codo.acodo.repository.revisar_repositorios.MmateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/materia")
public class MmateriaController {
    @Autowired
    private MmateriaRepository mmr;

    @Autowired
    private MexameneRepository mer;



    @GetMapping
    @RequestMapping( "/add")
    public String agregarMateria(Model model,@RequestParam(required = false, name = "id") Long id) {

        model.addAttribute("idExamen",id);
        return "agregar-materia";
    }


    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    @RequestMapping("/save")
    public ResponseEntity guardarMateria(Long idexamen,Long id,Integer cantPreguntas,String nombre){
        Mexamen nuevo=mer.findById(idexamen).orElse(null);
        System.out.println("el examen buscado es este !!!!!"+nuevo);
        System.out.println(idexamen);
        System.out.println(id);
        System.out.println(cantPreguntas);
        System.out.println(nombre);
        System.out.println("examen vista previa "+nuevo);
       Mmateria nueva=new Mmateria();
       nueva.setId(id);
       nueva.setCantPreguntas(cantPreguntas);
       nueva.setNombre(nombre);
       nueva.setMexamen(nuevo);
       nuevo.getMaterias().add(mmr.save(nueva));
       mer.save(nuevo);


        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/delete")
    public ResponseEntity eliminarMateria(Model model, @RequestParam(required = false, name = "id") Long id) throws Exception {
        try {
            mmr.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e){
            throw new Exception();
        }

    }




    @GetMapping
    @RequestMapping( "/listamaterias")
    public String refreshlistaexa(Model model) {
        List<Mmateria> itemList = mmr.findAll();

        model.addAttribute("materias", itemList);

        return "plantilla-materia :: listamaterias";
    }

    @GetMapping
    @RequestMapping( "/formulariomateria")
    public String refreshformex(Model model,@RequestParam(required = false, name = "id") Long id) {
        Mmateria mat=new Mmateria();

        if (id!=null){
            mat=mmr.findById(id).orElse(null);
        }

        model.addAttribute("mat",mat);

        return "plantilla-materia :: agregar_editar_materia";
    }

}




