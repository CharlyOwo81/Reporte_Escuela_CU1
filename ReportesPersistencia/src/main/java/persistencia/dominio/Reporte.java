/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.util.Calendar;

/**
 *
 * @author Oliver Valle
 */
public class Reporte {
    private Long id ;
    private Alumno alumno ;
    private Docente docente ;
    private NivelIncidencia nivelIncidencia ;
    String descripcion ;
    String motivo ;
    Calendar fechaHora ;
    boolean notificado, validado ;

    public Reporte(Long id, Alumno alumno, Docente docente, NivelIncidencia nivelIncidencia, String descripcion, String motivo, Calendar fechaHora, boolean notificado, boolean validado) {
        this.id = id ;
        this.alumno = alumno;
        this.docente = docente;
        this.nivelIncidencia = nivelIncidencia;
        this.descripcion = descripcion;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
        this.notificado = notificado;
        this.validado = validado ;
    }

    public Reporte(Alumno alumno, Docente docente, NivelIncidencia nivelIncidencia, String descripcion, String motivo, Calendar fechaHora, boolean notificado, boolean validado) {
        this.alumno = alumno;
        this.docente = docente;
        this.nivelIncidencia = nivelIncidencia;
        this.descripcion = descripcion;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
        this.notificado = notificado;
        this.validado = validado;
    }

    public Long getId() {
        return id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Docente getDocente() {
        return docente;
    }

    public NivelIncidencia getNivelIncidencia() {
        return nivelIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public boolean isNotificado() {
        return notificado;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setNivelIncidencia(NivelIncidencia nivelIncidencia) {
        this.nivelIncidencia = nivelIncidencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
    
    
    
}
