/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.entidades;

import java.util.Calendar;

/**
 *
 * @author Oliver Valle
 */
public class AlumnoEntity {
    
    private Long id ;
    private String CURP, nombre, apellidoP, apellidoM, gradoGrupo, urlFoto ;
    private Long telefonoTutor ;

    public AlumnoEntity(Long id, String CURP, String nombre, String apellidoP, String apellidoM, String gradoGrupo, Long telefonoTutor, String urlFoto) {
        this.id = id;
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gradoGrupo = gradoGrupo;
        this.telefonoTutor = telefonoTutor;
        this.urlFoto = urlFoto ;
    }

    public AlumnoEntity(String CURP, String nombre, String apellidoP, String apellidoM, String gradoGrupo, Long telefonoTutor, String urlFoto) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gradoGrupo = gradoGrupo;
        this.telefonoTutor = telefonoTutor;
        this.urlFoto = urlFoto ;
    }
    
    public Long getId() {
        return id;
    }

    public String getCURP() {
        return CURP;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getGradoGrupo() {
        return gradoGrupo;
    }

    public Long getTelefonoTutor() {
        return telefonoTutor;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
    
}