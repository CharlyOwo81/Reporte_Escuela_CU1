/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.persistencia;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import persistencia.conexionBD.ConexionMongo;
import persistencia.entidades.AlumnoEntity;
import persistencia.entidades.DocenteEntity;
import persistencia.entidades.NivelIncidenciaPersistencia;
import persistencia.entidades.ReporteEntity;

/**
 *
 * @author Oliver Valle
 */
public class ReportesDAO implements IReportesDAO {
    
    private MongoCollection<ReporteEntity> coleccion;
    private static final Logger LOG = Logger.getLogger(ReportesDAO.class.getName());
    
    
    public ReportesDAO() {
        this.coleccion = ConexionMongo.obtenerColeccion();
    }
    
    public void insertarReportes(List<ReporteEntity> reportes) {
        try {
            coleccion.insertMany(reportes);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Ocurri\u00f3 algo al insertar reportes: {0}", e.getMessage());
        }
    }
    
    @Override
    public ReporteEntity validarReporte(ReporteEntity reporte) {
        
        
//        for (int i = 0; i < reportes.size(); i++) {
//            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
//                reportes.get(i).setValidado(true);
//                reportes.get(i).setDescripcion(reporte.getDescripcion());
//                reportes.get(i).setMotivo(reporte.getMotivo());
//                reportes.get(i).setNivelIncidencia(reporte.getNivelIncidencia());
//                return reportes.get(i) ;
//            }
//        }
        return null ;
    }

    @Override
    public ReporteEntity modificarReporte(ReporteEntity reporte) {
//        for (int i = 0; i < reportes.size(); i++) {
//            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
//                reportes.get(i).setDescripcion(reporte.getDescripcion());
//                reportes.get(i).setMotivo(reporte.getMotivo());
//                reportes.get(i).setNivelIncidencia(reporte.getNivelIncidencia());
//                return reportes.get(i) ;
//            }
//        }
        return null ;
    }

    @Override
    public boolean notificarReporte(ReporteEntity reporte) {
//        for (int i = 0; i < reportes.size(); i++) {
//            if(reportes.get(i).getAlumno().getCURP().equalsIgnoreCase(reporte.getAlumno().getCURP())) {
//                reportes.get(i).setNotificado(true);
//                return true ;
//            }
//        }
        return false ;
    }

    @Override
    public List<ReporteEntity> recuperarReportes() {
        return null ;
    }
    
    
    // Para pruebas
    public List<ReporteEntity> listaReportesSimulado() {
        AlumnoEntity alumno1 = new AlumnoEntity ("IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", 6878767707L, "src/main/java/fotos/foto_oliver.jpeg") ;
        AlumnoEntity alumno2 = new AlumnoEntity ("CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", 6448750493L, "src/main/java/fotos/foto_gael.jpeg") ;
        AlumnoEntity alumno3 = new AlumnoEntity ("AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", 6448094837L, "src/main/java/fotos/foto_asiel.jpeg") ;
        AlumnoEntity alumno4 = new AlumnoEntity ("OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", 6441840394L, "src/main/java/fotos/foto_amos.jpeg") ;
        AlumnoEntity alumno5 = new AlumnoEntity ("AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", 6878094837L, "src/main/java/fotos/foto_gama.jpg") ;
        AlumnoEntity alumno6 = new AlumnoEntity ("RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", 6878094837L, "src/main/java/fotos/foto_jp.jpeg") ;
        
        DocenteEntity docente1 = new DocenteEntity("GALJ940519HDFLRN05", "Juan", "García", "López") ;
        DocenteEntity docente2 = new DocenteEntity("ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        DocenteEntity docente3 = new DocenteEntity("PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;
        
        ReporteEntity reporte1 = new ReporteEntity(alumno4, docente1, 
                NivelIncidenciaPersistencia.GRAVE, "Se encontró al alumno fumando un tabaco en la entrada de los baños de hombres", 
                "Fumar Tabaco dentro de la Escuela", new Date(), false, false) ;
        ReporteEntity reporte2 = new ReporteEntity(alumno1, docente1, 
                NivelIncidenciaPersistencia.LEVE, "El alumno alzó la voz y ofendió con groserías a su compañero en el Aula", 
                "Hablar con Lenguaje Inapropiado", new Date(), false, false) ;
        ReporteEntity reporte3 = new ReporteEntity(alumno3, docente2, 
                NivelIncidenciaPersistencia.SEVERO, "Este alumno inició una pelea y su compañero al que agredió no pudo defenderse, fué leve y no pasó a mayores", 
                "Iniciar Pelea", new Date(), false, false) ;
        ReporteEntity reporte4 = new ReporteEntity(alumno5, docente2, 
                NivelIncidenciaPersistencia.LEVE, "El alumno lleva 1 semana entera faltando a mi clase de Matemáticas, no ha presentado justificante y diario se le puede ver como se va de otras clases", 
                "Inasistencia frecuente", new Date(), false, false) ;
        ReporteEntity reporte5 = new ReporteEntity(alumno6, docente3, 
                NivelIncidenciaPersistencia.LEVE, "Este alumno estuvo tirando basura dentro de la institución sin importarle las constantes llamadas de atención que le hice", 
                "Contaminación ambiental en la institución", new Date(), false, false) ;
        ReporteEntity reporte6 = new ReporteEntity(alumno2, docente3, 
                NivelIncidenciaPersistencia.GRAVE, "El alumno estuvo ingiriendo bebidas alcoholicas a media clase desde su termo", 
                "Consumo de bebidas alcoholicas dentro del salón", new Date(), false, false) ;
        
        List<ReporteEntity> reportes = new ArrayList<>();
        reportes.add(reporte1);
        reportes.add(reporte2);
        reportes.add(reporte3);
        reportes.add(reporte4);
        reportes.add(reporte5);
        reportes.add(reporte6);
        
        return reportes;
        
    }
    
}
