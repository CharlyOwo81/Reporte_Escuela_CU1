/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocios.bo;

import java.util.List;
import dto.ReporteDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IIncidenciasBO {
    ReporteDTO validarReporte(ReporteDTO reporteNuevo);
    
    boolean notificarReporte(ReporteDTO reporteNuevo);
    
    List<ReporteDTO> recuperarReportes();
    
    public void insertDatosSimulados();
}
