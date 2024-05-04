/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package persistencia.persistenciaEscuela;

import persistencia.entidades.AlumnoEntity;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface IAlumnoDAO {
    public AlumnoEntity obtenerAlumno(AlumnoEntity ae);
    public AlumnoEntity obtenerAlumnoPorCurp(AlumnoEntity ae);
}
