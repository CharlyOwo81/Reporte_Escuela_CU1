/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dto.ReporteDTO;
import java.util.List;
import negocios.bo.IIncidenciasBO;
import negocios.bo.IncidenciasBO;



/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidencias {

    private IIncidenciasBO incidenciasBO ;
    
    public GestionarIncidencias() {
        incidenciasBO = new IncidenciasBO() ;
    }
    
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        reporteNuevo.setValidado(true);
        return incidenciasBO.validarReporte(reporteNuevo) ;
    }

    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        reporteNuevo.setNotificado(true);
        return incidenciasBO.notificarReporte(reporteNuevo) ;
    }

    public List<ReporteDTO> recuperarReportes() {
        return incidenciasBO.recuperarReportes() ;
    }

    
    
}
