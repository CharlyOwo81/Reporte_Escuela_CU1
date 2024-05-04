package persistencia.persistenciaEscuela;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
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

}
