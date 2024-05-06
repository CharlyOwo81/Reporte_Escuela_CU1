package persistencia.persistenciaEscuela;

import persistencia.entidades.UsuarioEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface IUsuarioDAO {
    public void insertarDocentesSimulados();
    public UsuarioEntity obtenerDocente(UsuarioEntity de);
    public UsuarioEntity obtenerDocentePorCurp(UsuarioEntity de);
}
