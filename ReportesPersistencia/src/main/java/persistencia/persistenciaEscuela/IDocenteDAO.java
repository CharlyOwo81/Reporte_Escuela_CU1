package persistencia.persistenciaEscuela;

import persistencia.entidades.DocenteEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface IDocenteDAO {
    public DocenteEntity obtenerDocente(DocenteEntity de);
    public DocenteEntity obtenerDocentePorCurp(DocenteEntity de);
}
