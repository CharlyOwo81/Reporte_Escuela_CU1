/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import dto.ReporteDTO;
import java.util.List;

/**
 *
 * @author Oliver Valle
 */
public interface IFachadaGestionarIncidencias {
    ReporteDTO validarReporte(ReporteDTO reporteNuevo);
    
    boolean notificarReporte(ReporteDTO reporteNuevo);
    
    List<ReporteDTO> recuperarReportes();
    
    public void insertDatosSimulados();
}
