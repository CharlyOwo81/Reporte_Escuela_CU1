/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocios.subsistemas.gestionarincidencias;

import java.util.List;
import negocios.dto.ReporteDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IGestionarIncidencias {
    ReporteDTO validarReporte(ReporteDTO reporteNuevo);
    
    boolean notificarReporte(ReporteDTO reporteNuevo);
    
    List<ReporteDTO> recuperarReportes();
}
