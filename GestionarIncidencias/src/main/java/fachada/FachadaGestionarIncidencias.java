/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import java.util.List;
import control.GestionarIncidencias;
import dto.ReporteDTO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaGestionarIncidencias implements IFachadaGestionarIncidencias{

    private GestionarIncidencias boIncidencias ;
    
    public FachadaGestionarIncidencias() {
        boIncidencias = new GestionarIncidencias() ;
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
    
    
    public void insertReportesSimulados() {
        boIncidencias.insertReportesSimulados();
    }
    
}
