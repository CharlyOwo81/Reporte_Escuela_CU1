/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocios.negocios;

import java.util.List;
import negocios.dto.ReporteNuevoDTO;

/**
 *
 * @author Oliver Valle
 */
public interface IFachadaGestionIncidencias {
    ReporteNuevoDTO validarReporte(ReporteNuevoDTO reporteNuevo) ;
    
    boolean notificarReporte(ReporteNuevoDTO reporteNuevo) ;
    
    List<ReporteNuevoDTO> recuperarReportes() ;
}
