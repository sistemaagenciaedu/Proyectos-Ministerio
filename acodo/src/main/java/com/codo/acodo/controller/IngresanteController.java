package com.codo.acodo.controller;

import com.codo.acodo.entity.EmailMessage;
import com.codo.acodo.entity.Ingresante;
import com.codo.acodo.repository.IngresanteRepository;
import com.codo.acodo.services.EmailserviceApplication;
import com.codo.acodo.services.IngresanteService;
import com.codo.acodo.utiles.Listas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/ingresante")
public class IngresanteController {
@Autowired
  private IngresanteRepository ir;
@Autowired
    private Listas lis;
@Autowired
private IngresanteService is;


@GetMapping("/reg")
public String verRegistro(Model model){
    Ingresante ingresante=new Ingresante();
    model.addAttribute("ingresante",ingresante);
    model.addAttribute("listaNacionalidades", lis.devolverNacionalidades());
    return "registro";
}
    @PostMapping("/save")
   public String saveIngre(Ingresante ingresante, Model model) throws Exception{
       Ingresante ingre=ir.save(ingresante);
       String usuario=ingre.getNombre()+" "+ingre.getApellido();
       Long ingreid=ingre.getId();
        EmailMessage mail= new EmailMessage();
        mail.setTo_address(ingresante.getMail());
        mail.setBody("<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "\t<meta name=\"x-apple-disable-message-reformatting\">\n" +
                "\t<title></title>\n" +
                "\t\n" +
                "\t<style>\n" +
                "\t\ttable, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td align=\"center\" style=\"padding:0;\">\n" +
                "\t\t\t\t<table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td align=\"center\" style=\"padding:40px 0 30px 0;background:#fdd306;\">\n" +
                "\t\t\t\t\t\t\t<img src=\"https://agenciadeaprendizaje.bue.edu.ar/wp-content/uploads/2020/11/logos-header.png\" alt=\"\" width=\"300\" style=\"height:auto;display:block;\" />\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td style=\"padding:36px 30px 42px 30px;\">\n" +
                "\t\t\t\t\t\t\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"padding:0 0 36px 0;color:#153643;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">"+usuario+"</h1>\n" +
                "\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Gracias por registrarte en el programa Codo a Codo, el siguiente paso sera activar tu cuenta en el siguiente link</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"><a href=\"http://localhost:8080/ingresante/activar?id="+ingreid+"\" style=\"color:#ee4c50;text-decoration:none; font-weight: bold;\">&#128073; ACTIVAR CUENTA</a></p>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"padding:0;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width:260px;padding:0;vertical-align:top;color:#153643;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 25px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"><img src=\"https://assets.codepen.io/210284/left.gif\" alt=\"\" width=\"260\" style=\"height:auto;display:block;\" /></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus adipiscing felis, sit amet blandit ipsum volutpat sed. Morbi porttitor, eget accumsan dictum, est nisi libero ultricies ipsum, in posuere mauris neque at erat.</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"><a href=\"http://www.example.com\" style=\"color:#ee4c50;text-decoration:underline;\">Blandit ipsum volutpat sed</a></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width:20px;padding:0;font-size:0;line-height:0;\">&nbsp;</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width:260px;padding:0;vertical-align:top;color:#153643;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 25px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"><img src=\"https://assets.codepen.io/210284/right.gif\" alt=\"\" width=\"260\" style=\"height:auto;display:block;\" /></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">Morbi porttitor, eget est accumsan dictum, nisi libero ultricies ipsum, in posuere mauris neque at erat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tempus adipiscing felis, sit amet blandit ipsum volutpat sed.</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\"><a href=\"http://www.example.com\" style=\"color:#ee4c50;text-decoration:underline;\">In tempus felis blandit</a></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td style=\"padding:30px;background:#ee4c50;\">\n" +
                "\t\t\t\t\t\t\t<table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"padding:0;width:50%;\" align=\"left\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<p style=\"margin:0;font-size:14px;line-height:16px;font-family:Arial,sans-serif;color:#ffffff;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t&reg; Someone, Somewhere 2021<br/><a href=\"http://www.example.com\" style=\"color:#ffffff;text-decoration:underline;\">Unsubscribe</a>\n" +
                "\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"padding:0;width:50%;\" align=\"right\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<table role=\"presentation\" style=\"border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://www.twitter.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/tw_1.png\" alt=\"Twitter\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding:0 0 0 10px;width:38px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://www.facebook.com/\" style=\"color:#ffffff;\"><img src=\"https://assets.codepen.io/210284/fb_1.png\" alt=\"Facebook\" width=\"38\" style=\"height:auto;display:block;border:0;\" /></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</body>\n" +
                "</html>");
        mail.setSubject("codo a Codo");
       EmailserviceApplication ems=new EmailserviceApplication();
       ems.sendmail(mail);

model.addAttribute("usu", usuario);
       return "registro-exitoso";
   }

   @GetMapping("/activar")
    public String activarUsuario(Long id, Model model){
       System.out.println(id);
       Ingresante ingre=ir.findById(id).orElse(null);
       ingre.setActivado("SI");
       ir.save(ingre);
       model.addAttribute("usu",ingre.getNombre()+" "+ingre.getApellido());
return "activado";
   }


}

