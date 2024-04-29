/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.persistencia;

import java.util.List;
import persistencia.entidades.ReporteEntity;

/**
 *
 * @author Oliver Valle
 */
public interface IReportesDAO {
    
    ReporteEntity validarReporte(ReporteEntity reporte);
    
    ReporteEntity modificarReporte(ReporteEntity reporte);
    
    boolean notificarReporte(ReporteEntity reporte);
    
    List<ReporteEntity> recuperarReportes();
    
    public void insertarReportesSimulados();
    
}
