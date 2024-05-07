/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package persistencia.persistenciaEscuela;

import java.util.List;
import persistencia.entidades.AlumnoEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface IAlumnoDAO {
    public void insertarAlumnosSimulados();
    public AlumnoEntity obtenerAlumno(AlumnoEntity ae);
    public AlumnoEntity obtenerAlumnoPorCurp(AlumnoEntity ae);
    public List<AlumnoEntity> recuperarAlumnosPorGrado(String grado) ;
    public List<AlumnoEntity> recuperarAlumnosPorGrupo(String grupo) ;
    public List<AlumnoEntity> recuperarAlumnosPorGradoYGrupo(String grado, String grupo) ;
}
