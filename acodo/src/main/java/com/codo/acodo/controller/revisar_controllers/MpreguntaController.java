    package com.codo.acodo.controller.revisar_controllers;

    import com.codo.acodo.entity.revisar_entidades.Mmateria;
    import com.codo.acodo.entity.revisar_entidades.Mpregunta;
    import com.codo.acodo.repository.revisar_repositorios.MexameneRepository;
    import com.codo.acodo.repository.revisar_repositorios.MmateriaRepository;
    import com.codo.acodo.repository.revisar_repositorios.MpreguntaRepository;
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
    @RequestMapping("/pregunta")
    public class MpreguntaController {
        @Autowired
        private MmateriaRepository mmr;

        @Autowired
        private MexameneRepository mer;

        @Autowired
        private MpreguntaRepository mpr;



        @GetMapping
        @RequestMapping( "/add")
        public String agregarMateria(Model model, @RequestParam(required = false, name = "id") Long id) {

            model.addAttribute("idMateria",id);
            return "agregar-pregunta";
        }


        @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
        )
        @RequestMapping("/save")
        public ResponseEntity guardarPregunta(
                Long id,
                Long idMateria,
        String tienePortada,
        String formatoPortada,
        String videoP,
        String imagenP,
        String audioP,
        String enunciado,
        String formatoRespuesta,
        String pos1,
        String pos2,
        String pos3,
        String pos4,
        String pos5,
        String pos6,
        String pos7,
        String pos8,
        String correcta){

            System.out.println(id);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Mmateria nuevo=mmr.findById(idMateria).orElse(null);
            Mpregunta nueva=new Mpregunta();
            nueva.setId(id);
            nueva.setTienePortada(tienePortada);
            nueva.setFormatoPortada(formatoPortada);
            nueva.setVideoP(videoP);
            nueva.setAudioP(audioP);
            nueva.setImagenP(imagenP);
            nueva.setEnunciado(enunciado);
            nueva.setFormatoRespuesta(formatoRespuesta);
            nueva.setPos1(pos1);
            nueva.setPos2(pos2);
            nueva.setPos3(pos3);
            nueva.setPos4(pos4);
            nueva.setPos5(pos5);
            nueva.setPos6(pos6);
            nueva.setPos7(pos7);
            nueva.setPos8(pos8);
            nueva.setCorrecta(correcta);
            nueva.setMmateria(nuevo);
            nuevo.getPreguntas().add(mpr.save(nueva));
            mmr.save(nuevo);


            return ResponseEntity.ok(HttpStatus.CREATED);
        }

        @GetMapping("/delete")
        public ResponseEntity eliminarPregunta(Model model, @RequestParam(required = false, name = "id") Long id) throws Exception {
            try {
                mmr.deleteById(id);
                return ResponseEntity.ok(HttpStatus.OK);
            }catch (Exception e){
                throw new Exception();
            }

        }




        @GetMapping
        @RequestMapping( "/listapreguntas")
        public String refreshlistapre(Model model) {
            List<Mpregunta> itemList = mpr.findAll();
            for (Mpregunta pre:itemList) {
                System.out.println(pre);
            }

            model.addAttribute("preguntas", itemList);

            return "plantilla-pregunta :: listaPreguntas2";
        }

        @GetMapping
        @RequestMapping( "/formulariopregunta")
        public String refreshforpre(Model model,@RequestParam(required = false, name = "id") Long id) {
            Mpregunta pre=new Mpregunta();

            if (id!=null){
                pre=mpr.findById(id).orElse(null);
            }

            model.addAttribute("pre",pre);

            return "plantilla-pregunta :: agregar_editar_pregunta";
        }

    }




