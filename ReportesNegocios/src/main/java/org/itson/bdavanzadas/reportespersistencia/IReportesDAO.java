/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.reportespersistencia;

import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IReportesDAO {
    
    Reporte validarReporte(ReporteNuevoDTO reporte) ;
    
    Reporte modificarReporte(ReporteNuevoDTO reporte) ;
    
    boolean notificarReporte(ReporteNuevoDTO reporte) ;
    
    List<Reporte> recuperarReportes() ;
    
}
