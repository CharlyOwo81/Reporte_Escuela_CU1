/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.negocios;

import java.util.LinkedList;
import java.util.List;
import persistencia.dominio.Alumno;
import persistencia.dominio.Docente;
import persistencia.dominio.Reporte;
import negocios.dto.AlumnoNuevoDTO;
import negocios.dto.DocenteNuevoDTO;
import negocios.dto.ReporteNuevoDTO;
import persistencia.persistencia.IReportesDAO;
import persistencia.persistencia.ReportesDAO;



/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidencias implements IFachadaGestionIncidencias {

    private IReportesDAO reportesDAO ;
    
    public GestionarIncidencias() {
        reportesDAO = new ReportesDAO() ;
    }
    
    @Override
    public ReporteNuevoDTO validarReporte(ReporteNuevoDTO reporte) {
        Alumno alumnoEnviar = new Alumno(
                reporte.getAlumno().getCURP(),
                reporte.getAlumno().getNombre(), 
                reporte.getAlumno().getApellidoP(), 
                reporte.getAlumno().getApellidoM(), 
                reporte.getAlumno().getGradoGrupo(), 
                reporte.getAlumno().getTelefonoTutor(), 
                reporte.getAlumno().getUrlFoto()
        ) ;
        
        Docente docenteEnviar = new Docente(
                reporte.getDocente().getCURP(),
                reporte.getDocente().getNombre(),
                reporte.getDocente().getApellidoP(), 
        reporte.getDocente().getApellidoM()) ;
        
        Reporte reporteEnviar = new Reporte(
                alumnoEnviar,
                docenteEnviar,
                reporte.getNivelIncidencia(),
                reporte.getDescripcion(), 
                reporte.getMotivo(), 
                reporte.getFechaHora(), 
                reporte.isNotificado(), 
                reporte.isValidado()
        ) ;
        
        Reporte reporteObtenido = reportesDAO.validarReporte(reporteEnviar) ;

        AlumnoNuevoDTO alumnoObtenido = new AlumnoNuevoDTO(
                reporteObtenido.getAlumno().getCURP(),
                reporteObtenido.getAlumno().getNombre(),
                reporteObtenido.getAlumno().getApellidoP(),
                reporteObtenido.getAlumno().getApellidoM(),
                reporteObtenido.getAlumno().getGradoGrupo(),
                reporteObtenido.getAlumno().getTelefonoTutor(),
                reporteObtenido.getAlumno().getUrlFoto()
        );

        DocenteNuevoDTO docenteObtenido = new DocenteNuevoDTO(
                reporteObtenido.getDocente().getCURP(),
                reporteObtenido.getDocente().getNombre(),
                reporteObtenido.getDocente().getApellidoP(),
                reporteObtenido.getDocente().getApellidoM()
        );

        return new ReporteNuevoDTO(
                alumnoObtenido,
                docenteObtenido,
                reporteObtenido.getNivelIncidencia(),
                reporteObtenido.getDescripcion(),
                reporteObtenido.getMotivo(),
                reporteObtenido.getFechaHora(),
                reporteObtenido.isNotificado(),
                reporteObtenido.isValidado()
        );
        
    }


    @Override
    public boolean notificarReporte(ReporteNuevoDTO reporte) {
        Alumno alumnoEnviar = new Alumno(
                reporte.getAlumno().getCURP(),
                reporte.getAlumno().getNombre(), 
                reporte.getAlumno().getApellidoP(), 
                reporte.getAlumno().getApellidoM(), 
                reporte.getAlumno().getGradoGrupo(), 
                reporte.getAlumno().getTelefonoTutor(), 
                reporte.getAlumno().getUrlFoto()
        ) ;
        
        Docente docenteEnviar = new Docente(
                reporte.getDocente().getCURP(),
                reporte.getDocente().getNombre(),
                reporte.getDocente().getApellidoP(), 
        reporte.getDocente().getApellidoM()) ;
        
        Reporte reporteEnviar = new Reporte(
                alumnoEnviar,
                docenteEnviar,
                reporte.getNivelIncidencia(),
                reporte.getDescripcion(), 
                reporte.getMotivo(), 
                reporte.getFechaHora(), 
                reporte.isNotificado(), 
                reporte.isValidado()
        ) ;
        
        return reportesDAO.notificarReporte(reporteEnviar) ;
    }

    @Override
    public List<ReporteNuevoDTO> recuperarReportes() {
        List<ReporteNuevoDTO> reportes = new LinkedList() ;
        reportesDAO.recuperarReportes().forEach(reporte -> {
            AlumnoNuevoDTO alumnoObtenido = new AlumnoNuevoDTO(
                    reporte.getAlumno().getCURP(),
                    reporte.getAlumno().getNombre(),
                    reporte.getAlumno().getApellidoP(),
                    reporte.getAlumno().getApellidoM(),
                    reporte.getAlumno().getGradoGrupo(),
                    reporte.getAlumno().getTelefonoTutor(),
                    reporte.getAlumno().getUrlFoto()
            );

            DocenteNuevoDTO docenteObtenido = new DocenteNuevoDTO(
                    reporte.getDocente().getCURP(),
                    reporte.getDocente().getNombre(),
                    reporte.getDocente().getApellidoP(),
                    reporte.getDocente().getApellidoM()
            );
            reportes.add(new ReporteNuevoDTO(
                    alumnoObtenido,
                    docenteObtenido,
                    reporte.getNivelIncidencia(),
                    reporte.getDescripcion(),
                    reporte.getMotivo(),
                    reporte.getFechaHora(),
                    reporte.isNotificado(),
                    reporte.isValidado()
            )) ;
        });
        
        return reportes ;
    }
    
}
