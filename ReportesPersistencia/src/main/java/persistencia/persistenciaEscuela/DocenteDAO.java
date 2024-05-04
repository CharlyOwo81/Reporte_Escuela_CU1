package persistencia.persistenciaEscuela;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexionBD.ConexionEscuela;
import persistencia.entidades.DocenteEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class DocenteDAO implements IDocenteDAO{

    private MongoCollection<DocenteEntity> coleccion;
    private static final Logger LOG = Logger.getLogger(DocenteDAO.class.getName());
    
    
    public DocenteDAO() {
        this.coleccion = ConexionEscuela.obtenerBaseDeDatos().getCollection("Docentes", DocenteEntity.class);;
    }
    
    @Override
    public void insertarDocentesSimulados() {
        try {
            if(coleccion.countDocuments() == 0) {
                coleccion.insertMany(listaDocentesSimulado());
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Ya hay docentes insertados", e.getMessage());
        }
    }
    
    @Override
    public DocenteEntity obtenerDocente(DocenteEntity de) {
        try {
            if(de.getId() == null) throw new Exception("El id del docente es nulo.");
            return coleccion.find(Filters.eq("_id", de.getId())).first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public DocenteEntity obtenerDocentePorCurp(DocenteEntity de) {
        try {
            if(de.getCURP() == null) throw new Exception("La curp del docente es nula.");
            return coleccion.find(Filters.eq("CURP", de.getCURP())).first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
    
    // Para pruebas
    private List<DocenteEntity> listaDocentesSimulado() {
        DocenteEntity docente1 = new DocenteEntity("GALJ940519HDFLRN05", "Juan", "García", "López", "1234") ;
        DocenteEntity docente2 = new DocenteEntity("ROHM000712MDFDRR07", "María", "Rodríguez", "Hernández", "1234") ;
        DocenteEntity docente3 = new DocenteEntity("PEMC010224HDFRRL00", "Carlos", "Pérez", "Martínez", "1234") ;
        
        List<DocenteEntity> docentes = new ArrayList<>();
        docentes.add(docente1);
        docentes.add(docente2);
        docentes.add(docente3);
        
        return docentes;
    }

    

}
