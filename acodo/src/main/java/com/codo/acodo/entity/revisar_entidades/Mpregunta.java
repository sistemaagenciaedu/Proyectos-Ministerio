package com.codo.acodo.entity.revisar_entidades;

import javax.persistence.*;

@Entity
@Table(name="mpregunta")
public class Mpregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tienePortada;
    private String formatoPortada;
    private String videoP;
    private String imagenP;
    private String audioP;
    private String enunciado;
    private String formatoRespuesta;
    private String pos1;
    private String pos2;
    private String pos3;
    private String pos4;
    private String pos5;
    private String pos6;
    private String pos7;
    private String pos8;
    private String correcta;

    private String respuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mmateria" )
    private Mmateria mmateria;

    public Mpregunta() {
    }

    public Mpregunta(Long id, String tienePortada, String formatoPortada, String videoP, String imagenP, String audioP, String enunciado, String formatoRespuesta, String pos1, String pos2, String pos3, String pos4, String pos5, String pos6, String pos7, String pos8, String correcta, String respuesta, Mmateria mmateria) {
        this.id = id;
        this.tienePortada = tienePortada;
        this.formatoPortada = formatoPortada;
        this.videoP = videoP;
        this.imagenP = imagenP;
        this.audioP = audioP;
        this.enunciado = enunciado;
        this.formatoRespuesta = formatoRespuesta;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.pos3 = pos3;
        this.pos4 = pos4;
        this.pos5 = pos5;
        this.pos6 = pos6;
        this.pos7 = pos7;
        this.pos8 = pos8;
        this.correcta = correcta;
        this.respuesta = respuesta;
        this.mmateria = mmateria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTienePortada() {
        return tienePortada;
    }

    public void setTienePortada(String tienePortada) {
        this.tienePortada = tienePortada;
    }

    public String getFormatoPortada() {
        return formatoPortada;
    }

    public void setFormatoPortada(String formatoPortada) {
        this.formatoPortada = formatoPortada;
    }

    public String getVideoP() {
        return videoP;
    }

    public void setVideoP(String videoP) {
        this.videoP = videoP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }

    public String getAudioP() {
        return audioP;
    }

    public void setAudioP(String audioP) {
        this.audioP = audioP;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getFormatoRespuesta() {
        return formatoRespuesta;
    }

    public void setFormatoRespuesta(String formatoRespuesta) {
        this.formatoRespuesta = formatoRespuesta;
    }

    public String getPos1() {
        return pos1;
    }

    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

    public String getPos2() {
        return pos2;
    }

    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }

    public String getPos3() {
        return pos3;
    }

    public void setPos3(String pos3) {
        this.pos3 = pos3;
    }

    public String getPos4() {
        return pos4;
    }

    public void setPos4(String pos4) {
        this.pos4 = pos4;
    }

    public String getPos5() {
        return pos5;
    }

    public void setPos5(String pos5) {
        this.pos5 = pos5;
    }

    public String getPos6() {
        return pos6;
    }

    public void setPos6(String pos6) {
        this.pos6 = pos6;
    }

    public String getPos7() {
        return pos7;
    }

    public void setPos7(String pos7) {
        this.pos7 = pos7;
    }

    public String getPos8() {
        return pos8;
    }

    public void setPos8(String pos8) {
        this.pos8 = pos8;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public Mmateria getMmateria() {
        return mmateria;
    }

    public void setMmateria(Mmateria mmateria) {
        this.mmateria = mmateria;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Mpregunta{" +
                "id=" + id +
                ", tienePortada='" + tienePortada + '\'' +
                ", formatoPortada='" + formatoPortada + '\'' +
                ", videoP='" + videoP + '\'' +
                ", imagenP='" + imagenP + '\'' +
                ", audioP='" + audioP + '\'' +
                ", enunciado='" + enunciado + '\'' +
                ", formatoRespuesta='" + formatoRespuesta + '\'' +
                ", pos1='" + pos1 + '\'' +
                ", pos2='" + pos2 + '\'' +
                ", pos3='" + pos3 + '\'' +
                ", pos4='" + pos4 + '\'' +
                ", pos5='" + pos5 + '\'' +
                ", pos6='" + pos6 + '\'' +
                ", pos7='" + pos7 + '\'' +
                ", pos8='" + pos8 + '\'' +
                ", correcta='" + correcta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
