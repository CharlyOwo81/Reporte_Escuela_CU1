/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocios.bo;

import dto.AlumnoDTO;
import java.util.List;
import dto.ReporteDTO;
import dto.ReporteExpedienteDTO ;

/**
 *
 * @author Oliver Valle
 */
public interface IIncidenciasBO {
    ReporteDTO validarReporte(ReporteDTO reporteNuevo);
    
    boolean notificarReporte(ReporteDTO reporteNuevo);
    
    List<ReporteDTO> recuperarReportes();
    
    public void insertDatosSimulados();
    
    public List<AlumnoDTO> recuperarAlumnosPorGrado(String grado);
    
    public List<AlumnoDTO> recuperarAlumnosPorGrupo(String grupo);
    
    public List<AlumnoDTO> recuperarAlumnosPorGradoYGrupo(String grado, String grupo);
    
    public List<ReporteDTO> recuperarReportesAlumno(String curp) ;
    
    public List<ReporteExpedienteDTO> convertirReporteAReporteExpediente(List<ReporteDTO> reportes) ;
}
