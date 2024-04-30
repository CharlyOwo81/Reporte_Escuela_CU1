/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Oliver Valle
 */
public class AlumnoDTO {
    private String CURP, nombre, apellidoP, apellidoM, gradoGrupo, urlFoto, emailTutor ;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String CURP, String nombre, String apellidoP, String apellidoM, String gradoGrupo, String urlFoto, String emailTutor) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gradoGrupo = gradoGrupo;
        this.urlFoto = urlFoto;
        this.emailTutor = emailTutor;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
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

    public String getEmailTutor() {
        return emailTutor;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
}
