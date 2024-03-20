/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportesnegocios;

import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;
import org.itson.bdavanzadas.reportespersistencia.IReportesDAO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaNotificar implements IFachadaNotificar{
    
    private IReportesDAO reportesDAO ;
    
    public FachadaNotificar(IReportesDAO reportesDAO) {
        this.reportesDAO = reportesDAO ;
    }

    @Override
    public boolean notificarReporte(ReporteNuevoDTO reporte) {
        return reportesDAO.notificarReporte(reporte) ;
    }
    
}
