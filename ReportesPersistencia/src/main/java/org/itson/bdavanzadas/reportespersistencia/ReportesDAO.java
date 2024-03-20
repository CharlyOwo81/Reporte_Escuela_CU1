/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportespersistencia;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Alumno;
import org.itson.bdavanzadas.reportesdominio.Docente;
import org.itson.bdavanzadas.reportesdominio.NivelIncidencia;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;

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
    public Reporte validarReporte(ReporteNuevoDTO reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().equals(reporte.getAlumno())) {
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
    public Reporte modificarReporte(ReporteNuevoDTO reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().equals(reporte.getAlumno())) {
                reportes.get(i).setDescripcion(reporte.getDescripcion());
                reportes.get(i).setMotivo(reporte.getMotivo());
                reportes.get(i).setNivelIncidencia(reporte.getNivelIncidencia());
                return reportes.get(i) ;
            }
        }
        return null ;
    }

    @Override
    public boolean notificarReporte(ReporteNuevoDTO reporte) {
        for (int i = 0; i < reportes.size(); i++) {
            if(reportes.get(i).getAlumno().equals(reporte.getAlumno())) {
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
        Alumno alumno1 = new Alumno (1L, "IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", 6878767707L, "src/main/java/fotos/foto_oliver.jpeg") ;
        Alumno alumno2 = new Alumno (2L, "CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", 6448750493L, "src/main/java/fotos/foto_gael.jpeg") ;
        Alumno alumno3 = new Alumno (3L, "AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", 6448094837L, "src/main/java/fotos/foto_asiel.jpeg") ;
        Alumno alumno4 = new Alumno (3L, "OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", 6441840394L, "src/main/java/fotos/foto_amos.jpeg") ;
        Alumno alumno5 = new Alumno (3L, "AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", 6878094837L, "src/main/java/fotos/foto_gama.jpg") ;
        Alumno alumno6 = new Alumno (3L, "RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", 6878094837L, "src/main/java/fotos/foto_jp.jpeg") ;
        
        Docente docente1 = new Docente(1L, "GALJ940519HDFLRN05", "Juan", "García", "López") ;
        Docente docente2 = new Docente(2L, "ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        Docente docente3 = new Docente(3L, "PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;
        
        Reporte reporte1 = new Reporte(1L, alumno4, docente1, 
                NivelIncidencia.GRAVE, "Se encontró al alumno fumando un tabaco en la entrada de los baños de hombres", 
                "Fumar Tabaco dentro de la Escuela", new GregorianCalendar(), false, false) ;
        Reporte reporte2 = new Reporte(2L, alumno1, docente1, 
                NivelIncidencia.LEVE, "El alumno alzó la voz y ofendió con groserías a su compañero en el Aula", 
                "Hablar con Lenguaje Inapropiado", new GregorianCalendar(), false, false) ;
        Reporte reporte3 = new Reporte(3L, alumno3, docente2, 
                NivelIncidencia.SEVERO, "Este alumno inició una pelea y su compañero al que agredió no pudo defenderse, fué leve y no pasó a mayores", 
                "Iniciar Pelea", new GregorianCalendar(), false, false) ;
        Reporte reporte4 = new Reporte(4L, alumno5, docente2, 
                NivelIncidencia.LEVE, "El alumno lleva 1 semana entera faltando a mi clase de Matemáticas, no ha presentado justificante y diario se le puede ver como se va de otras clases", 
                "Inasistencia frecuente", new GregorianCalendar(), false, false) ;
        Reporte reporte5 = new Reporte(5L, alumno6, docente3, 
                NivelIncidencia.LEVE, "Este alumno estuvo tirando basura dentro de la institución sin importarle las constantes llamadas de atención que le hice", 
                "Contaminación ambiental en la institución", new GregorianCalendar(), false, false) ;
        Reporte reporte6 = new Reporte(6L, alumno2, docente3, 
                NivelIncidencia.GRAVE, "El alumno estuvo ingiriendo bebidas alcoholicas a media clase desde su termo", 
                "Consumo de bebidas alcoholicas dentro del salón", new GregorianCalendar(), false, false) ;
        
        reportes.add(reporte1) ;
        reportes.add(reporte2) ;      
        reportes.add(reporte3) ;
        reportes.add(reporte4) ;
        reportes.add(reporte5) ;
        reportes.add(reporte6) ;
        
    }
    
}
