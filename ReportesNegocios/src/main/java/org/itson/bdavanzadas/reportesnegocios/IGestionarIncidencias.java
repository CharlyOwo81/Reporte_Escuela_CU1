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
 * @author gamaliel
 */
public interface IGestionarIncidencias {
    Reporte validarReporte(ReporteNuevoDTO reporte) ;
    boolean notificarReporte(ReporteNuevoDTO reporte) ;
    List<Reporte> recuperarReportes() ;
    Reporte modificarReporte(ReporteNuevoDTO reporte) ;
}
