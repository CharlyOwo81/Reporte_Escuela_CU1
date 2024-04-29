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
    private String _id, CURP, nombre, apellidoP, apellidoM, gradoGrupo, urlFoto ;
    private Long telefonoTutor ;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String _id, String CURP, String nombre, String apellidoP, String apellidoM, String gradoGrupo, String urlFoto, Long telefonoTutor) {
        this._id = _id;
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gradoGrupo = gradoGrupo;
        this.urlFoto = urlFoto;
        this.telefonoTutor = telefonoTutor;
    }
    
    public AlumnoDTO(String CURP, String nombre, String apellidoP, String apellidoM, String gradoGrupo, Long telefonoTutor, String urlFoto) {
        this.CURP = CURP;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gradoGrupo = gradoGrupo;
        this.telefonoTutor = telefonoTutor;
        this.urlFoto = urlFoto ;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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

    public Long getTelefonoTutor() {
        return telefonoTutor;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
}
