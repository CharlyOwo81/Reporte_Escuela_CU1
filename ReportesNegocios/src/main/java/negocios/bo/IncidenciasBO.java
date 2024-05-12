/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.bo;

import java.util.List;
import dto.AlumnoDTO;
import dto.UsuarioDTO;
import dto.ReporteDTO;
import dto.ReporteExpedienteDTO;
import fachada.FachadaSistemaMensajeria;
import fachada.IFachadaSistemaMensajeria;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import persistencia.entidades.AlumnoEntity;
import persistencia.entidades.ReporteEntity;
import persistencia.entidades.UsuarioEntity;
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
    public void crearReporte(ReporteDTO reporteNuevo) {
        UsuarioEntity usuario = new UsuarioEntity(
                reporteNuevo.getDocente().getCurp(),
                reporteNuevo.getDocente().getNombre(),
                reporteNuevo.getDocente().getApellidoP(),
                reporteNuevo.getDocente().getApellidoM(),
                reporteNuevo.getDocente().getRol(),
                reporteNuevo.getDocente().getPin());

        AlumnoEntity alumno = new AlumnoEntity(
                reporteNuevo.getAlumno().getCurp(),
                reporteNuevo.getAlumno().getNombre(),
                reporteNuevo.getAlumno().getApellidoP(),
                reporteNuevo.getAlumno().getApellidoM(),
                reporteNuevo.getAlumno().getGradoGrupo(),
                reporteNuevo.getAlumno().getEmailTutor(),
                reporteNuevo.getAlumno().getUrlFoto());

        ReporteEntity reporteCreado = new ReporteEntity();

        reporteCreado.setValidado(false);
        reporteCreado.setNotificado(false);

        reporteCreado.setUsuario(usuario);
        reporteCreado.setAlumno(alumno);

        reporteCreado.setFechaHora(reporteNuevo.getFechaHora());
        reporteCreado.setDescripcion(reporteNuevo.getDescripcion());
        reporteCreado.setMotivo(reporteNuevo.getMotivo());
        reporteCreado.setNivelIncidencia(reporteNuevo.getNivelIncidencia());

        reportesDAO.insertarReporte(reporteCreado);
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
    
    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGrado(String grado) {
        List<AlumnoEntity> alumnosPorGrado = alumnoDAO.recuperarAlumnosPorGrado(grado) ;
        
        List<AlumnoDTO> alumnosPorGradoDTO = new ArrayList() ;
        
        if (alumnosPorGrado.isEmpty() || alumnosPorGrado == null) {
            return null ;
        }
        
        for (AlumnoEntity alumnoObtenido : alumnosPorGrado) {

            AlumnoDTO alumnoDTO = new AlumnoDTO(
                    alumnoObtenido.getCURP(),
                    alumnoObtenido.getNombre(),
                    alumnoObtenido.getApellidoP(),
                    alumnoObtenido.getApellidoM(),
                    alumnoObtenido.getGradoGrupo(),
                    alumnoObtenido.getUrlFoto(),
                    alumnoObtenido.getEmailTutor()
            );
            
            alumnosPorGradoDTO.add(alumnoDTO);
        }
        
        return alumnosPorGradoDTO ;
        
    }

    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGrupo(String grupo) {
        List<AlumnoEntity> alumnosPorGrupo = alumnoDAO.recuperarAlumnosPorGrupo(grupo) ;
        
        List<AlumnoDTO> alumnosPorGrupoDTO = new ArrayList() ;
        
        if (alumnosPorGrupo.isEmpty() || alumnosPorGrupo == null) {
            return null ;
        }
        
        for (AlumnoEntity alumnoObtenido : alumnosPorGrupo) {

            AlumnoDTO alumnoDTO = new AlumnoDTO(
                    alumnoObtenido.getCURP(),
                    alumnoObtenido.getNombre(),
                    alumnoObtenido.getApellidoP(),
                    alumnoObtenido.getApellidoM(),
                    alumnoObtenido.getGradoGrupo(),
                    alumnoObtenido.getUrlFoto(),
                    alumnoObtenido.getEmailTutor()
            );
            
            alumnosPorGrupoDTO.add(alumnoDTO);
        }
        
        return alumnosPorGrupoDTO ;
    }

    @Override
    public List<AlumnoDTO> recuperarAlumnosPorGradoYGrupo(String grado, String grupo) {
        List<AlumnoEntity> alumnosPorGradoYGrupo = alumnoDAO.recuperarAlumnosPorGradoYGrupo(grado, grupo) ;
        
        List<AlumnoDTO> alumnosPorGradoYGrupoDTO = new ArrayList() ;
        
        if (alumnosPorGradoYGrupo.isEmpty() || alumnosPorGradoYGrupo == null) {
            return null ;
        }
        
        for (AlumnoEntity alumnoObtenido : alumnosPorGradoYGrupo) {

            AlumnoDTO alumnoDTO = new AlumnoDTO(
                    alumnoObtenido.getCURP(),
                    alumnoObtenido.getNombre(),
                    alumnoObtenido.getApellidoP(),
                    alumnoObtenido.getApellidoM(),
                    alumnoObtenido.getGradoGrupo(),
                    alumnoObtenido.getUrlFoto(),
                    alumnoObtenido.getEmailTutor()
            );
            
            alumnosPorGradoYGrupoDTO.add(alumnoDTO);
        }
        
        return alumnosPorGradoYGrupoDTO ;
    }
    
    @Override
    public List<ReporteDTO> recuperarReportesAlumno(String curp) {
        List<ReporteEntity> reportesAlumno = reportesDAO.recuperarReportesAlumno(curp);
        if (reportesAlumno == null && reportesAlumno.isEmpty()) {
            return null;
        }
        
        List<ReporteDTO> reportesAlumnoDTO = new ArrayList<>();
        
        for (ReporteEntity reporteObtenido : reportesAlumno) {

            AlumnoDTO alumnoDto = new AlumnoDTO(
                    reporteObtenido.getAlumno().getCURP(),
                    reporteObtenido.getAlumno().getNombre(),
                    reporteObtenido.getAlumno().getApellidoP(),
                    reporteObtenido.getAlumno().getApellidoM(),
                    reporteObtenido.getAlumno().getGradoGrupo(),
                    reporteObtenido.getAlumno().getUrlFoto(),
                    reporteObtenido.getAlumno().getEmailTutor()
            );

            UsuarioDTO docenteDto = new UsuarioDTO(
                    reporteObtenido.getUsuario().getCurp(),
                    reporteObtenido.getUsuario().getNombre(),
                    reporteObtenido.getUsuario().getApellidoP(),
                    reporteObtenido.getUsuario().getApellidoM()
            );
            
            ReporteDTO reporteDTO = new ReporteDTO(
                    reporteObtenido.getId().toHexString(),
                    alumnoDto,
                    docenteDto,
                    reporteObtenido.getNivelIncidencia(),
                    reporteObtenido.getDescripcion(),
                    reporteObtenido.getMotivo(),
                    reporteObtenido.getFechaHora(),
                    reporteObtenido.isNotificado(),
                    reporteObtenido.isValidado()
            );
            
            reportesAlumnoDTO.add(reporteDTO);
        }
        return reportesAlumnoDTO;
    }
    
    @Override
    public List<ReporteExpedienteDTO> convertirReporteAReporteExpediente(List<ReporteDTO> reportes) {
        List<ReporteExpedienteDTO> reportesExpedientes = new ArrayList() ;
        
        reportes.forEach(reporte -> {
            String nombreAlumno = reporte.getAlumno().getNombre() + " " + reporte.getAlumno().getApellidoP() + " " + reporte.getAlumno().getApellidoM() ;
            String nombreDocente = reporte.getDocente().getNombre() + " " + reporte.getDocente().getApellidoP() + " " + reporte.getDocente().getApellidoM() ;
            reportesExpedientes.add(new ReporteExpedienteDTO(
                    reporte.getAlumno().getCurp(),
                    nombreAlumno,
                    nombreDocente,
                    reporte.getNivelIncidencia().toString(),
                    reporte.getDescripcion(),
                    reporte.getMotivo(),
                    fechaEnFormato(reporte.getFechaHora())
            )) ;
        });
        
        return reportesExpedientes ;
    }
    
    private String fechaEnFormato(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        return sdf.format(date);
    }
}
