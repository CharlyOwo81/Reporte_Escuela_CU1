/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.fachadas;

import java.util.List;
import negocios.bo.GestionarIncidenciasBO;
import negocios.bo.IGestionarIncidenciasBO;
import negocios.dto.ReporteDTO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaGestionarIncidencias implements IFachadaGestionarIncidencias{

    private IGestionarIncidenciasBO boIncidencias ;
    
    public FachadaGestionarIncidencias() {
        boIncidencias = new GestionarIncidenciasBO() ;
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        return boIncidencias.validarReporte(reporteNuevo) ;
    }

    @Override
    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        return boIncidencias.notificarReporte(reporteNuevo) ;
    }

    @Override
    public List<ReporteDTO> recuperarReportes() {
        return boIncidencias.recuperarReportes() ;
    }
    
}
