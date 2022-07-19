package codoacodo.com.intro.entities;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "ingresante")
public class Ingresante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private Long celu;
    private String tDoc;
    private String numDoc;
    private String apellido;
    private String nombre;
    private String fNacimiento;
    private String genero;
    private String nacionalidad;
    private String pais;
    private String provincia;
    private String localidadResi;
    private String domicilio;
    private String clave;



}





