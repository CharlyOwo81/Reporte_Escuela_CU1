/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.bo;

import java.util.List;
import dto.AlumnoDTO;
import dto.UsuarioDTO;
import dto.ReporteDTO;
import fachada.FachadaSistemaMensajeria;
import fachada.IFachadaSistemaMensajeria;
import java.util.ArrayList;
import org.bson.types.ObjectId;
import persistencia.entidades.ReporteEntity;
import persistencia.persistenciaEscuela.AlumnoDAO;
import persistencia.persistenciaEscuela.UsuarioDAO;
import persistencia.persistenciaSistema.IReportesDAO;
import persistencia.persistenciaSistema.ReportesDAO;
import persistencia.persistenciaEscuela.IAlumnoDAO;
import persistencia.persistenciaEscuela.IUsuarioDAO;

/**
 *
 * @author Oliver Valle
 */
public class IncidenciasBO implements IIncidenciasBO{

    private final IReportesDAO reportesDAO;
    private final IAlumnoDAO alumnoDAO;
    private final IUsuarioDAO usuarioDAO;
    private final IFachadaSistemaMensajeria sistemaMensajeria;
    
    public IncidenciasBO() {
        this.reportesDAO  = new ReportesDAO();
        this.alumnoDAO = new AlumnoDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.sistemaMensajeria = new FachadaSistemaMensajeria();
    }
    
    @Override
    public void insertDatosSimulados() {
        reportesDAO.insertarReportesSimulados();
        alumnoDAO.insertarAlumnosSimulados();
        usuarioDAO.insertarDocentesSimulados();
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteDto) {
        ReporteEntity reporteObtenido = new ReporteEntity();
        
        reporteObtenido.setId(new ObjectId(reporteDto.getId()));
        reporteObtenido.setValidado(reporteDto.isValidado());
        
        reporteObtenido = reportesDAO.validarReporte(reporteObtenido);
        
        if(reporteObtenido == null) return null;
        AlumnoDTO alumnoObtenido = new AlumnoDTO(
                reporteObtenido.getAlumno().getId(),
                reporteObtenido.getAlumno().getCURP(),
                reporteObtenido.getAlumno().getNombre(),
                reporteObtenido.getAlumno().getApellidoP(),
                reporteObtenido.getAlumno().getApellidoM(),
                reporteObtenido.getAlumno().getGradoGrupo(),
                reporteObtenido.getAlumno().getUrlFoto(),
                reporteObtenido.getAlumno().getEmailTutor()
        );

        UsuarioDTO usuarioObtenido = new UsuarioDTO(
                reporteObtenido.getUsuario().getId(),
                reporteObtenido.getUsuario().getCurp(),
                reporteObtenido.getUsuario().getNombre(),
                reporteObtenido.getUsuario().getApellidoP(),
                reporteObtenido.getUsuario().getApellidoM(),
                reporteObtenido.getUsuario().getRol(),
                reporteObtenido.getUsuario().getPin()
                
        );

        return new ReporteDTO(
                reporteObtenido.getId().toHexString(),
                alumnoObtenido,
                usuarioObtenido,
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
        // Lógica para hacer notificación 
        if(sistemaMensajeria.enviarMensaje(reporteDto)) { // Si se pudo enviar el mensaje, se cambia el estado de notificación del reporte
            // Lógica para cambiar estádo a notificado
            ReporteEntity reporteEntity = new ReporteEntity();
            reporteEntity.setId(new ObjectId(reporteDto.getId()));
            return reportesDAO.notificarReporte(reporteEntity); // Retorna verdadero si se pudo cambiar el estado de notificación del reporte
        }
        return false; // No se pudo enviar el mensaje
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
                    reporteObtenido.getAlumno().getId(),
                    reporteObtenido.getAlumno().getCURP(),
                    reporteObtenido.getAlumno().getNombre(),
                    reporteObtenido.getAlumno().getApellidoP(),
                    reporteObtenido.getAlumno().getApellidoM(),
                    reporteObtenido.getAlumno().getGradoGrupo(),
                    reporteObtenido.getAlumno().getUrlFoto(),
                    reporteObtenido.getAlumno().getEmailTutor()
            );

            UsuarioDTO usuarioDto = new UsuarioDTO(
                    reporteObtenido.getUsuario().getId(),
                    reporteObtenido.getUsuario().getCurp(),
                    reporteObtenido.getUsuario().getNombre(),
                    reporteObtenido.getUsuario().getApellidoP(),
                    reporteObtenido.getUsuario().getApellidoM(),
                    reporteObtenido.getUsuario().getRol(),
                    reporteObtenido.getUsuario().getPin()
            );
            
            ReporteDTO reporteDTO = new ReporteDTO(
                    reporteObtenido.getId().toHexString(),
                    alumnoDto,
                    usuarioDto,
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
}
