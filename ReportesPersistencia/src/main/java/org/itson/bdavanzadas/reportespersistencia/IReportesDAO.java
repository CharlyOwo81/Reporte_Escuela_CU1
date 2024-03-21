/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.reportespersistencia;

import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Reporte;

/**
 *
 * @author Oliver Valle
 */
public interface IReportesDAO {
    
    Reporte validarReporte(Reporte reporte) ;
    
    Reporte modificarReporte(Reporte reporte) ;
    
    boolean notificarReporte(Reporte reporte) ;
    
    List<Reporte> recuperarReportes() ;
    
}
