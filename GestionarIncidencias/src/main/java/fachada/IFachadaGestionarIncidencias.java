/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import dto.AlumnoDTO;
import dto.ReporteDTO;
import dto.ReporteExpedienteDTO;
import java.util.List;

/**
 *
 * @author Oliver Valle
 */
public interface IFachadaGestionarIncidencias {
    ReporteDTO validarReporte(ReporteDTO reporteNuevo);
    
    void crearReporte(ReporteDTO reporteNuevo);
    
    boolean notificarReporte(ReporteDTO reporteNuevo);
    
    List<ReporteDTO> recuperarReportes();
    
    public void insertDatosSimulados();
    
    public List<AlumnoDTO> recuperarAlumnosPorGrado(String grado);
    
    public List<AlumnoDTO> recuperarAlumnosPorGrupo(String grupo);
    
    public List<AlumnoDTO> recuperarAlumnosPorGradoYGrupo(String grado, String grupo);
    
    public List<ReporteDTO> recuperarReportesAlumno(String curp);
    
    public List<ReporteExpedienteDTO> convertirReportesAReporteExpediente(List<ReporteDTO> reportes) ;
}
