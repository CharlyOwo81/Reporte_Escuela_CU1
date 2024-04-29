/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.bo;

import java.util.List;
import dto.AlumnoDTO;
import dto.DocenteDTO;
import dto.ReporteDTO;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import persistencia.entidades.ReporteEntity;
import persistencia.persistencia.IReportesDAO;
import persistencia.persistencia.ReportesDAO;

/**
 *
 * @author Oliver Valle
 */
public class IncidenciasBO implements IIncidenciasBO{

    private IReportesDAO reportesDAO;
    
    public IncidenciasBO() {
        this.reportesDAO  = new ReportesDAO();
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteDto) {
        ReporteEntity reporteObtenido = new ReporteEntity();
        
        reporteObtenido.setId(new ObjectId(reporteDto.getId()));
        reporteObtenido.setValidado(reporteDto.isValidado());
        
        reporteObtenido = reportesDAO.validarReporte(reporteObtenido);
        
        if(reporteObtenido == null) return null;
        AlumnoDTO alumnoObtenido = new AlumnoDTO(
                reporteObtenido.getAlumno().getCURP(),
                reporteObtenido.getAlumno().getNombre(),
                reporteObtenido.getAlumno().getApellidoP(),
                reporteObtenido.getAlumno().getApellidoM(),
                reporteObtenido.getAlumno().getGradoGrupo(),
                reporteObtenido.getAlumno().getUrlFoto(),
                reporteObtenido.getAlumno().getTelefonoTutor()
        );

        DocenteDTO docenteObtenido = new DocenteDTO(
                reporteObtenido.getDocente().getCURP(),
                reporteObtenido.getDocente().getNombre(),
                reporteObtenido.getDocente().getApellidoP(),
                reporteObtenido.getDocente().getApellidoM()
        );

        return new ReporteDTO(
                reporteObtenido.getId().toString(),
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
    public boolean notificarReporte(ReporteDTO reporteDto) {
//        for (int i = 0; i < reportes.size(); i++) {
//            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporteNuevo.getAlumno().getCURP())) {
//                reportes.set(i, reporteNuevo) ;
//                return true ;
//            }
//        }
        return false ;
    }

    @Override
    public List<ReporteDTO> recuperarReportes() {
        List<ReporteEntity> reportesEntity = reportesDAO.recuperarReportes();
        if (reportesEntity == null && reportesEntity.isEmpty()) {
            return null;
        }
        
        List<ReporteDTO> reportesDto = new ArrayList<>();
        
        for (ReporteEntity reporteObtenido : reportesEntity) {

            AlumnoDTO alumnoDto = new AlumnoDTO(
                    reporteObtenido.getAlumno().getCURP(),
                    reporteObtenido.getAlumno().getNombre(),
                    reporteObtenido.getAlumno().getApellidoP(),
                    reporteObtenido.getAlumno().getApellidoM(),
                    reporteObtenido.getAlumno().getGradoGrupo(),
                    reporteObtenido.getAlumno().getUrlFoto(),
                    reporteObtenido.getAlumno().getTelefonoTutor()
            );

            DocenteDTO docenteDto = new DocenteDTO(
                    reporteObtenido.getDocente().getCURP(),
                    reporteObtenido.getDocente().getNombre(),
                    reporteObtenido.getDocente().getApellidoP(),
                    reporteObtenido.getDocente().getApellidoM()
            );

            ReporteDTO reporteDTO = new ReporteDTO(
                    reporteObtenido.getId().toString(),
                    alumnoDto,
                    docenteDto,
                    reporteObtenido.getNivelIncidencia(),
                    reporteObtenido.getDescripcion(),
                    reporteObtenido.getMotivo(),
                    reporteObtenido.getFechaHora(),
                    reporteObtenido.isNotificado(),
                    reporteObtenido.isValidado()
            );
            
            reportesDto.add(reporteDTO);
        }
        return reportesDto;
    }
    
    
    
    
    //EN TEORIA ESTE DEBERÍA DE SER EL CÓDIGO EN EL FUTURO
//    private IReportesDAO reportesDAO ;
//    
//    public GestionarIncidencias() {
//        reportesDAO = new ReportesDAO() ;
//    }
//    
//    @Override
//    public ReporteNuevoDTO validarReporte(ReporteNuevoDTO reporte) {
//        Alumno alumnoEnviar = new Alumno(
//                reporte.getAlumno().getCURP(),
//                reporte.getAlumno().getNombre(), 
//                reporte.getAlumno().getApellidoP(), 
//                reporte.getAlumno().getApellidoM(), 
//                reporte.getAlumno().getGradoGrupo(), 
//                reporte.getAlumno().getTelefonoTutor(), 
//                reporte.getAlumno().getUrlFoto()
//        ) ;
//        
//        Docente docenteEnviar = new Docente(
//                reporte.getDocente().getCURP(),
//                reporte.getDocente().getNombre(),
//                reporte.getDocente().getApellidoP(), 
//        reporte.getDocente().getApellidoM()) ;
//        
//        Reporte reporteEnviar = new Reporte(
//                alumnoEnviar,
//                docenteEnviar,
//                reporte.getNivelIncidencia(),
//                reporte.getDescripcion(), 
//                reporte.getMotivo(), 
//                reporte.getFechaHora(), 
//                reporte.isNotificado(), 
//                reporte.isValidado()
//        ) ;
//        
//        Reporte reporteObtenido = reportesDAO.validarReporte(reporteEnviar) ;
//
//        AlumnoNuevoDTO alumnoObtenido = new AlumnoNuevoDTO(
//                reporteObtenido.getAlumno().getCURP(),
//                reporteObtenido.getAlumno().getNombre(),
//                reporteObtenido.getAlumno().getApellidoP(),
//                reporteObtenido.getAlumno().getApellidoM(),
//                reporteObtenido.getAlumno().getGradoGrupo(),
//                reporteObtenido.getAlumno().getTelefonoTutor(),
//                reporteObtenido.getAlumno().getUrlFoto()
//        );
//
//        DocenteNuevoDTO docenteObtenido = new DocenteNuevoDTO(
//                reporteObtenido.getDocente().getCURP(),
//                reporteObtenido.getDocente().getNombre(),
//                reporteObtenido.getDocente().getApellidoP(),
//                reporteObtenido.getDocente().getApellidoM()
//        );
//
//        return new ReporteNuevoDTO(
//                alumnoObtenido,
//                docenteObtenido,
//                reporteObtenido.getNivelIncidencia(),
//                reporteObtenido.getDescripcion(),
//                reporteObtenido.getMotivo(),
//                reporteObtenido.getFechaHora(),
//                reporteObtenido.isNotificado(),
//                reporteObtenido.isValidado()
//        );
//        
//    }
//
//
//    @Override
//    public boolean notificarReporte(ReporteNuevoDTO reporte) {
//        Alumno alumnoEnviar = new Alumno(
//                reporte.getAlumno().getCURP(),
//                reporte.getAlumno().getNombre(), 
//                reporte.getAlumno().getApellidoP(), 
//                reporte.getAlumno().getApellidoM(), 
//                reporte.getAlumno().getGradoGrupo(), 
//                reporte.getAlumno().getTelefonoTutor(), 
//                reporte.getAlumno().getUrlFoto()
//        ) ;
//        
//        Docente docenteEnviar = new Docente(
//                reporte.getDocente().getCURP(),
//                reporte.getDocente().getNombre(),
//                reporte.getDocente().getApellidoP(), 
//        reporte.getDocente().getApellidoM()) ;
//        
//        Reporte reporteEnviar = new Reporte(
//                alumnoEnviar,
//                docenteEnviar,
//                reporte.getNivelIncidencia(),
//                reporte.getDescripcion(), 
//                reporte.getMotivo(), 
//                reporte.getFechaHora(), 
//                reporte.isNotificado(), 
//                reporte.isValidado()
//        ) ;
//        
//        return reportesDAO.notificarReporte(reporteEnviar) ;
//    }
//
//    @Override
//    public List<ReporteNuevoDTO> recuperarReportes() {
//        List<ReporteNuevoDTO> reportes = new LinkedList() ;
//        reportesDAO.recuperarReportes().forEach(reporte -> {
//            AlumnoNuevoDTO alumnoObtenido = new AlumnoNuevoDTO(
//                    reporte.getAlumno().getCURP(),
//                    reporte.getAlumno().getNombre(),
//                    reporte.getAlumno().getApellidoP(),
//                    reporte.getAlumno().getApellidoM(),
//                    reporte.getAlumno().getGradoGrupo(),
//                    reporte.getAlumno().getTelefonoTutor(),
//                    reporte.getAlumno().getUrlFoto()
//            );
//
//            DocenteNuevoDTO docenteObtenido = new DocenteNuevoDTO(
//                    reporte.getDocente().getCURP(),
//                    reporte.getDocente().getNombre(),
//                    reporte.getDocente().getApellidoP(),
//                    reporte.getDocente().getApellidoM()
//            );
//            reportes.add(new ReporteNuevoDTO(
//                    alumnoObtenido,
//                    docenteObtenido,
//                    reporte.getNivelIncidencia(),
//                    reporte.getDescripcion(),
//                    reporte.getMotivo(),
//                    reporte.getFechaHora(),
//                    reporte.isNotificado(),
//                    reporte.isValidado()
//            )) ;
//        });
//        
//        return reportes ;
//    }
}
