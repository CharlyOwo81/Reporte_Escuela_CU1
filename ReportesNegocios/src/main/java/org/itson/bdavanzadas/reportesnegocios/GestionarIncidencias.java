/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportesnegocios;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Alumno;
import org.itson.bdavanzadas.reportesdominio.Docente;
import org.itson.bdavanzadas.reportesdominio.NivelIncidencia;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.AlumnoNuevoDTO;
import org.itson.bdavanzadas.reportesdto.DocenteNuevoDTO;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;

/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidencias implements IFachadaGestionIncidencias {

    private List<ReporteNuevoDTO> reportes ;
    
    public GestionarIncidencias() {
        cargarDatos() ;
    }
    
    @Override
    public ReporteNuevoDTO validarReporte(ReporteNuevoDTO reporte) {
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
    public List<ReporteNuevoDTO> recuperarReportes() {
        return reportes ;
    }
    
    private void cargarDatos() {
        reportes = new LinkedList() ;
        AlumnoNuevoDTO alumno1 = new AlumnoNuevoDTO ("IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", 6878767707L, "src/main/java/fotos/foto_oliver.jpeg") ;
        AlumnoNuevoDTO alumno2 = new AlumnoNuevoDTO ("CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", 6448750493L, "src/main/java/fotos/foto_gael.jpeg") ;
        AlumnoNuevoDTO alumno3 = new AlumnoNuevoDTO ( "AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", 6448094837L, "src/main/java/fotos/foto_asiel.jpeg") ;
        AlumnoNuevoDTO alumno4 = new AlumnoNuevoDTO ( "OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", 6441840394L, "src/main/java/fotos/foto_amos.jpeg") ;
        AlumnoNuevoDTO alumno5 = new AlumnoNuevoDTO ( "AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", 6878094837L, "src/main/java/fotos/foto_gama.jpg") ;
        AlumnoNuevoDTO alumno6 = new AlumnoNuevoDTO ( "RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", 6878094837L, "src/main/java/fotos/foto_jp.jpeg") ;
        
        DocenteNuevoDTO docente1 = new DocenteNuevoDTO("GALJ940519HDFLRN05", "Juan", "García", "López") ;
        DocenteNuevoDTO docente2 = new DocenteNuevoDTO("ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        DocenteNuevoDTO docente3 = new DocenteNuevoDTO("PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;
        
        ReporteNuevoDTO reporte1 = new ReporteNuevoDTO(alumno4, docente1, 
                NivelIncidencia.GRAVE, "Se encontró al alumno fumando un tabaco en la entrada de los baños de hombres", 
                "Fumar Tabaco dentro de la Escuela", new GregorianCalendar(), false, false) ;
        ReporteNuevoDTO reporte2 = new ReporteNuevoDTO(alumno1, docente1, 
                NivelIncidencia.LEVE, "El alumno alzó la voz y ofendió con groserías a su compañero en el Aula", 
                "Hablar con Lenguaje Inapropiado", new GregorianCalendar(), false, false) ;
        ReporteNuevoDTO reporte3 = new ReporteNuevoDTO(alumno3, docente2, 
                NivelIncidencia.SEVERO, "Este alumno inició una pelea y su compañero al que agredió no pudo defenderse, fué leve y no pasó a mayores", 
                "Iniciar Pelea", new GregorianCalendar(), false, false) ;
        ReporteNuevoDTO reporte4 = new ReporteNuevoDTO(alumno5, docente2, 
                NivelIncidencia.LEVE, "El alumno lleva 1 semana entera faltando a mi clase de Matemáticas, no ha presentado justificante y diario se le puede ver como se va de otras clases", 
                "Inasistencia frecuente", new GregorianCalendar(), false, false) ;
        ReporteNuevoDTO reporte5 = new ReporteNuevoDTO(alumno6, docente3, 
                NivelIncidencia.LEVE, "Este alumno estuvo tirando basura dentro de la institución sin importarle las constantes llamadas de atención que le hice", 
                "Contaminación ambiental en la institución", new GregorianCalendar(), false, false) ;
        ReporteNuevoDTO reporte6 = new ReporteNuevoDTO(alumno2, docente3, 
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
