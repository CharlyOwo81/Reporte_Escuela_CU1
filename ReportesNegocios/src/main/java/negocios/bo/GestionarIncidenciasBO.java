/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.bo;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import negocios.dto.AlumnoDTO;
import negocios.dto.DocenteDTO;
import negocios.dto.ReporteDTO;
import persistencia.dominio.NivelIncidencia;

/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidenciasBO implements IGestionarIncidenciasBO{

    List<ReporteDTO> reportes ;
    
    public GestionarIncidenciasBO() {
        cargarDatos() ;
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporteNuevo.getAlumno().getCURP())) {
                reportes.get(i).setValidado(true);
                reportes.get(i).setDescripcion(reporteNuevo.getDescripcion());
                reportes.get(i).setMotivo(reporteNuevo.getMotivo());
                reportes.get(i).setNivelIncidencia(reporteNuevo.getNivelIncidencia());
                return reportes.get(i) ;
            }
        }
        return null ;
    }

    @Override
    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporteNuevo.getAlumno().getCURP())) {
                reportes.get(i).setNotificado(true);
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<ReporteDTO> recuperarReportes() {
        return reportes ;
    }
    
    private void cargarDatos() {
        reportes = new LinkedList<>() ;
        AlumnoDTO alumno1 = new AlumnoDTO ("IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", 6878767707L, "src/main/java/fotos/foto_oliver.jpeg") ;
        AlumnoDTO alumno2 = new AlumnoDTO ("CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", 6448750493L, "src/main/java/fotos/foto_gael.jpeg") ;
        AlumnoDTO alumno3 = new AlumnoDTO ("AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", 6448094837L, "src/main/java/fotos/foto_asiel.jpeg") ;
        AlumnoDTO alumno4 = new AlumnoDTO ("OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", 6441840394L, "src/main/java/fotos/foto_amos.jpeg") ;
        AlumnoDTO alumno5 = new AlumnoDTO ("AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", 6878094837L, "src/main/java/fotos/foto_gama.jpg") ;
        AlumnoDTO alumno6 = new AlumnoDTO ("RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", 6878094837L, "src/main/java/fotos/foto_jp.jpeg") ;

        DocenteDTO docente1 = new DocenteDTO("GALJ940519HDFLRN05", "Juan", "García", "López") ;
        DocenteDTO docente2 = new DocenteDTO("ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        DocenteDTO docente3 = new DocenteDTO("PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;

        ReporteDTO reporte1 = new ReporteDTO(alumno4, docente1,
                NivelIncidencia.GRAVE, "Se encontró al alumno fumando un tabaco en la entrada de los baños de hombres",
                "Fumar Tabaco dentro de la Escuela", new GregorianCalendar(), false, false) ;
        ReporteDTO reporte2 = new ReporteDTO(alumno1, docente1,
                NivelIncidencia.LEVE, "El alumno alzó la voz y ofendió con groserías a su compañero en el Aula",
                "Hablar con Lenguaje Inapropiado", new GregorianCalendar(), false, false) ;
        ReporteDTO reporte3 = new ReporteDTO(alumno3, docente2,
                NivelIncidencia.SEVERO, "Este alumno inició una pelea y su compañero al que agredió no pudo defenderse, fué leve y no pasó a mayores",
                "Iniciar Pelea", new GregorianCalendar(), false, false) ;
        ReporteDTO reporte4 = new ReporteDTO(alumno5, docente2,
                NivelIncidencia.LEVE, "El alumno lleva 1 semana entera faltando a mi clase de Matemáticas, no ha presentado justificante y diario se le puede ver como se va de otras clases",
                "Inasistencia frecuente", new GregorianCalendar(), false, false) ;
        ReporteDTO reporte5 = new ReporteDTO(alumno6, docente3,
                NivelIncidencia.LEVE, "Este alumno estuvo tirando basura dentro de la institución sin importarle las constantes llamadas de atención que le hice",
                "Contaminación ambiental en la institución", new GregorianCalendar(), false, false) ;
        ReporteDTO reporte6 = new ReporteDTO(alumno2, docente3,
                NivelIncidencia.GRAVE, "El alumno estuvo ingiriendo bebidas alcoholicas a media clase desde su termo",
                "Consumo de bebidas alcoholicas dentro del salón", new GregorianCalendar(), false, false) ;

        reportes.add(reporte1) ;
        reportes.add(reporte2) ;
        reportes.add(reporte3) ;
        reportes.add(reporte4) ;
        reportes.add(reporte5) ;
        reportes.add(reporte6) ;
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
