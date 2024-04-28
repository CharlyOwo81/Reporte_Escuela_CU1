/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.persistencia;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import persistencia.entidades.AlumnoEntity;
import persistencia.entidades.DocenteEntity;
import persistencia.entidades.NivelIncidenciaPersistencia;
import persistencia.entidades.Reporte;

/**
 *
 * @author Oliver Valle
 */
public class ReportesDAO implements IReportesDAO {
    
    List<Reporte> reportes ;
    
    public ReportesDAO() {
        cargarDatos() ;
    }
    
    @Override
    public Reporte validarReporte(Reporte reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
                reportes.get(i).setValidado(true);
                reportes.get(i).setDescripcion(reporte.getDescripcion());
                reportes.get(i).setMotivo(reporte.getMotivo());
                reportes.get(i).setNivelIncidencia(reporte.getNivelIncidencia());
                return reportes.get(i) ;
            }
        }
        return null ;
    }

    @Override
    public Reporte modificarReporte(Reporte reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
                reportes.get(i).setDescripcion(reporte.getDescripcion());
                reportes.get(i).setMotivo(reporte.getMotivo());
                reportes.get(i).setNivelIncidencia(reporte.getNivelIncidencia());
                return reportes.get(i) ;
            }
        }
        return null ;
    }

    @Override
    public boolean notificarReporte(Reporte reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
                reportes.get(i).setNotificado(true);
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<Reporte> recuperarReportes() {
        return reportes ;
    }
    
    private void cargarDatos() {
        reportes = new LinkedList() ;
        AlumnoEntity alumno1 = new AlumnoEntity (1L, "IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", 6878767707L, "src/main/java/fotos/foto_oliver.jpeg") ;
        AlumnoEntity alumno2 = new AlumnoEntity (2L, "CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", 6448750493L, "src/main/java/fotos/foto_gael.jpeg") ;
        AlumnoEntity alumno3 = new AlumnoEntity (3L, "AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", 6448094837L, "src/main/java/fotos/foto_asiel.jpeg") ;
        AlumnoEntity alumno4 = new AlumnoEntity (3L, "OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", 6441840394L, "src/main/java/fotos/foto_amos.jpeg") ;
        AlumnoEntity alumno5 = new AlumnoEntity (3L, "AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", 6878094837L, "src/main/java/fotos/foto_gama.jpg") ;
        AlumnoEntity alumno6 = new AlumnoEntity (3L, "RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", 6878094837L, "src/main/java/fotos/foto_jp.jpeg") ;
        
        DocenteEntity docente1 = new DocenteEntity(1L, "GALJ940519HDFLRN05", "Juan", "García", "López") ;
        DocenteEntity docente2 = new DocenteEntity(2L, "ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        DocenteEntity docente3 = new DocenteEntity(3L, "PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;
        
        Reporte reporte1 = new Reporte(1L, alumno4, docente1, 
                NivelIncidenciaPersistencia.GRAVE, "Se encontró al alumno fumando un tabaco en la entrada de los baños de hombres", 
                "Fumar Tabaco dentro de la Escuela", new GregorianCalendar(), false, false) ;
        Reporte reporte2 = new Reporte(2L, alumno1, docente1, 
                NivelIncidenciaPersistencia.LEVE, "El alumno alzó la voz y ofendió con groserías a su compañero en el Aula", 
                "Hablar con Lenguaje Inapropiado", new GregorianCalendar(), false, false) ;
        Reporte reporte3 = new Reporte(3L, alumno3, docente2, 
                NivelIncidenciaPersistencia.SEVERO, "Este alumno inició una pelea y su compañero al que agredió no pudo defenderse, fué leve y no pasó a mayores", 
                "Iniciar Pelea", new GregorianCalendar(), false, false) ;
        Reporte reporte4 = new Reporte(4L, alumno5, docente2, 
                NivelIncidenciaPersistencia.LEVE, "El alumno lleva 1 semana entera faltando a mi clase de Matemáticas, no ha presentado justificante y diario se le puede ver como se va de otras clases", 
                "Inasistencia frecuente", new GregorianCalendar(), false, false) ;
        Reporte reporte5 = new Reporte(5L, alumno6, docente3, 
                NivelIncidenciaPersistencia.LEVE, "Este alumno estuvo tirando basura dentro de la institución sin importarle las constantes llamadas de atención que le hice", 
                "Contaminación ambiental en la institución", new GregorianCalendar(), false, false) ;
        Reporte reporte6 = new Reporte(6L, alumno2, docente3, 
                NivelIncidenciaPersistencia.GRAVE, "El alumno estuvo ingiriendo bebidas alcoholicas a media clase desde su termo", 
                "Consumo de bebidas alcoholicas dentro del salón", new GregorianCalendar(), false, false) ;
        
        reportes.add(reporte1) ;
        reportes.add(reporte2) ;      
        reportes.add(reporte3) ;
        reportes.add(reporte4) ;
        reportes.add(reporte5) ;
        reportes.add(reporte6) ;
        
    }
    
}
