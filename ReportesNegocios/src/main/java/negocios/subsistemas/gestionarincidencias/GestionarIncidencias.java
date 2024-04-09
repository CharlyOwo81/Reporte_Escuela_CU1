/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios.subsistemas.gestionarincidencias;

import java.util.List;
import negocios.dto.ReporteDTO;
import negocios.fachadas.FachadaGestionarIncidencias;
import negocios.fachadas.IFachadaGestionarIncidencias;



/**
 *
 * @author Oliver Valle
 */
public class GestionarIncidencias implements IGestionarIncidencias {

    private IFachadaGestionarIncidencias fachadaIncidencias ;
    
    public GestionarIncidencias() {
        fachadaIncidencias = new FachadaGestionarIncidencias() ;
    }
    
    @Override
    public ReporteDTO validarReporte(ReporteDTO reporteNuevo) {
        return fachadaIncidencias.validarReporte(reporteNuevo) ;
    }

    @Override
    public boolean notificarReporte(ReporteDTO reporteNuevo) {
        return fachadaIncidencias.notificarReporte(reporteNuevo) ;
    }

    @Override
    public List<ReporteDTO> recuperarReportes() {
        return fachadaIncidencias.recuperarReportes() ;
    }

    
    
}
