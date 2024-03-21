/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportesdto;

import java.util.Calendar;
import org.itson.bdavanzadas.reportesdominio.Alumno;
import org.itson.bdavanzadas.reportesdominio.Docente;
import org.itson.bdavanzadas.reportesdominio.NivelIncidencia;

/**
 *
 * @author Oliver Valle
 */
public class ReporteNuevoDTO {
    
    //Por ahora es asi, pero luego hay que cambiar Alumno y Docente por DTOs para trabajar con JPA
    private AlumnoNuevoDTO alumno ;
    private DocenteNuevoDTO docente ;
    private NivelIncidencia nivelIncidencia ;
    String descripcion ;
    String motivo ;
    Calendar fechaHora ;
    boolean notificado ;
    boolean validado ;

    public ReporteNuevoDTO() {
        
    }
    
    public ReporteNuevoDTO(AlumnoNuevoDTO alumno, DocenteNuevoDTO docente, NivelIncidencia nivelIncidencia, String descripcion, String motivo, Calendar fechaHora, boolean notificado, boolean validado) {
        this.alumno = alumno;
        this.docente = docente;
        this.nivelIncidencia = nivelIncidencia;
        this.descripcion = descripcion;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
        this.notificado = notificado;
        this.validado = validado ;
    }

    public AlumnoNuevoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoNuevoDTO alumno) {
        this.alumno = alumno;
    }

    public DocenteNuevoDTO getDocente() {
        return docente;
    }

    public void setDocente(DocenteNuevoDTO docente) {
        this.docente = docente;
    }

    public NivelIncidencia getNivelIncidencia() {
        return nivelIncidencia;
    }

    public void setNivelIncidencia(NivelIncidencia nivelIncidencia) {
        this.nivelIncidencia = nivelIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isNotificado() {
        return notificado;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }
    
    
    
}
