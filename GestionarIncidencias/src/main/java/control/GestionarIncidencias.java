/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dto.AlumnoDTO;
import dto.ReporteDTO;
import dto.ReporteExpedienteDTO;
import java.util.List;
import negocios.bo.IIncidenciasBO;
import negocios.bo.IncidenciasBO;



/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidencias {

    private IIncidenciasBO incidenciasBO ;
    
    public GestionarIncidencias() {
        incidenciasBO = new IncidenciasBO() ;
    }
    
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        reporteNuevo.setValidado(true);
        return incidenciasBO.validarReporte(reporteNuevo) ;
    }

    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        reporteNuevo.setNotificado(true);
        return incidenciasBO.notificarReporte(reporteNuevo) ;
    }

    public List<ReporteDTO> recuperarReportes() {
        return incidenciasBO.recuperarReportes() ;
    }
    
    public void insertDatosSimulados() {
        incidenciasBO.insertDatosSimulados();
    }

    public List<AlumnoDTO> recuperarAlumnosPorGrado(String grado) {
        return incidenciasBO.recuperarAlumnosPorGrado(grado) ;
    }
    
    public List<AlumnoDTO> recuperarAlumnosPorGrupo(String grupo) {
        return incidenciasBO.recuperarAlumnosPorGrupo(grupo) ;
    }
    
    public List<AlumnoDTO> recuperarAlumnosPorGradoYGrupo(String grado, String grupo) {
        return incidenciasBO.recuperarAlumnosPorGradoYGrupo(grado, grupo) ;
    }
    
    public List<ReporteDTO> recuperarReportesAlumno(String curp) {
        return incidenciasBO.recuperarReportesAlumno(curp) ;
    }
    
    public List<ReporteExpedienteDTO> convertirReportesAReporteExpediente(List<ReporteDTO> reportes) {
        return incidenciasBO.convertirReporteAReporteExpediente(reportes) ;
    }
    
}
