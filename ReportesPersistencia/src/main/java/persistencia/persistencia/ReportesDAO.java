/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexionBD.ConexionMongo;
import persistencia.entidades.Alumno;
import persistencia.entidades.Docente;
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
        this.coleccion = ConexionMongo.obtenerBaseDeDatos().getCollection("Reportes", ReporteEntity.class);;
    }
    
    @Override
    public ReporteEntity insertarReporte(ReporteEntity reporte) {
        try {
            coleccion.insertOne(reporte);
            return reporte;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Ocurri\u00f3 algo al insertar reportes: {0}", e.getMessage());
        } finally {
            return null;
        }
    }
    
    @Override
    public void insertarReportesSimulados() {
        try {
            if(coleccion.countDocuments() == 0) {
                coleccion.insertMany(listaReportesSimulado());
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Ya hay reportes insertados", e.getMessage());
        }
    }
    
    @Override
    public ReporteEntity validarReporte(ReporteEntity reporte) {
        ReporteEntity reporteBuscado = coleccion.find(Filters.eq("_id", reporte.getId())).first();
        if(reporteBuscado == null) return null;
        try {
            coleccion.updateOne(Filters.eq("_id", reporteBuscado.getId()), Updates.set("validado", reporte.isValidado()));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar el estado de validado: {0}", e.getMessage());
            return null;
        }
        return coleccion.find(Filters.eq("_id", reporteBuscado.getId())).first();
    }

    @Override
    public ReporteEntity modificarReporte(ReporteEntity reporte) {
        try {
            coleccion.replaceOne(Filters.eq("_id", reporte.getId()), reporte);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo modificar el reporte", e.getMessage());
            return null;
        }
        
        return coleccion.find(Filters.eq("_id", reporte.getId())).first();
    }

    @Override
    public boolean notificarReporte(ReporteEntity reporte) {
        try {
            coleccion.updateOne(Filters.eq("_id", reporte.getId()), Updates.set("notificado", true));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Hubo un error al cambiar estado de notificado: ", e.getMessage());
            return false;
        }
        
        return true;
    }

    @Override
    public List<ReporteEntity> recuperarReportes() {
        return coleccion.find().into(new ArrayList<>());
    }
    
    
    // Para pruebas
    private List<ReporteEntity> listaReportesSimulado() {
        Alumno alumno1 = new Alumno ("IUVO040706HSLNLLA2", "Oliver", "Inzunza", "Valle", "3B", "oliver.inzunza244748@potros.itson.edu.mx", "src/main/java/fotos/foto_oliver.jpeg") ;
        Alumno alumno2 = new Alumno ("CAMG040802HSRSLLA5", "Gael Rafael", "Castro", "Molina", "2A", "asiel.apodaca247722@potros.itson.edu.mx", "src/main/java/fotos/foto_gael.jpeg") ;
        Alumno alumno3 = new Alumno ("AOMA040301HSRPNSA3", "Asiel", "Apodaca", "Monge", "1C", "juan.delrio216014@potros.itson.edu.mx", "src/main/java/fotos/foto_asiel.jpeg") ;
        Alumno alumno4 = new Alumno ("OUQA040309HSRLRMA5", "Amós Helí", "Olguín", "Quiróz", "3A", "oliver.inzunza244748@potros.itson.edu.mx", "src/main/java/fotos/foto_amos.jpeg") ;
        Alumno alumno5 = new Alumno ("AEPG040701HSRRRMA6", "Gamaliel", "Armenta", "Perez", "1C", "asiel.apodaca247722@potros.itson.edu.mx", "src/main/java/fotos/foto_gama.jpg") ;
        Alumno alumno6 = new Alumno ("RITJ010224HSRXPNA4", "Juan Pablo", "Del Río", "Tapia", "3C", "juan.delrio216014@potros.itson.edu.mx", "src/main/java/fotos/foto_jp.jpeg") ;
        
        Docente docente1 = new Docente("GALJ940519HDFLRN05", "Juan", "García", "López") ;
        Docente docente2 = new Docente("ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández") ;
        Docente docente3 = new Docente("PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez") ;
        
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
