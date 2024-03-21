/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.reportesnegocios;

import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IFachadaGestionIncidencias {
    ReporteNuevoDTO validarReporte(ReporteNuevoDTO reporteNuevo) ;
    
    boolean notificarReporte(ReporteNuevoDTO reporteNuevo) ;
    
    List<ReporteNuevoDTO> recuperarReportes() ;
}
