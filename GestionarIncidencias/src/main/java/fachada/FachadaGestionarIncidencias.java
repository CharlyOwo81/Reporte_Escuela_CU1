/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import java.util.List;
import control.GestionarIncidencias;
import dto.AlumnoDTO;
import dto.ReporteDTO;
import dto.ReporteExpedienteDTO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaGestionarIncidencias implements IFachadaGestionarIncidencias{

    private GestionarIncidencias boIncidencias ;
    
    public FachadaGestionarIncidencias() {
        boIncidencias = new GestionarIncidencias() ;
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        return boIncidencias.validarReporte(reporteNuevo) ;
    }

    @Override
    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        return boIncidencias.notificarReporte(reporteNuevo) ;
    }

    @Override
    public List<ReporteDTO> recuperarReportes() {
        return boIncidencias.recuperarReportes() ;
    }
    
    
    public void insertDatosSimulados() {
        boIncidencias.insertDatosSimulados();
    }
    
    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGrado(String grado) {
        return boIncidencias.recuperarAlumnosPorGrado(grado) ;
    }

    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGrupo(String grupo) {
        return boIncidencias.recuperarAlumnosPorGrupo(grupo) ;
    }

    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGradoYGrupo(String grado, String grupo) {
        return boIncidencias.recuperarAlumnosPorGradoYGrupo(grado, grupo) ;
    }

    @Override
    public List<ReporteDTO> recuperarReportesAlumno(String curp) {
        return boIncidencias.recuperarReportesAlumno(curp) ;
    }
    
    @Override
    public List<ReporteExpedienteDTO> convertirReportesAReporteExpediente(List<ReporteDTO> reportes) {
        return boIncidencias.convertirReportesAReporteExpediente(reportes) ;
    }
    
}
