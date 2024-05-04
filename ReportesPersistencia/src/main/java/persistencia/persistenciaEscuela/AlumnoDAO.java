package persistencia.persistenciaEscuela;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.conexionBD.ConexionEscuela;
import persistencia.entidades.AlumnoEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class AlumnoDAO implements IAlumnoDAO{

    private MongoCollection<AlumnoEntity> coleccion;
    private static final Logger LOG = Logger.getLogger(AlumnoDAO.class.getName());
    
    
    public AlumnoDAO() {
        this.coleccion = ConexionEscuela.obtenerBaseDeDatos().getCollection("Alumnos", AlumnoEntity.class);;
    }
    
    @Override
    public AlumnoEntity obtenerAlumno(AlumnoEntity ae) {
        try {
            if(ae.getId() == null) throw new Exception("El id del alumno es nulo.");
            return coleccion.find(Filters.eq("_id", ae.getId())).first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    @Override
    public AlumnoEntity obtenerAlumnoPorCurp(AlumnoEntity ae) {
        try {
            if(ae.getCURP() == null) throw new Exception("La curp del docente es nula.");
            return coleccion.find(Filters.eq("CURP", ae.getCURP())).first();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
    

}
