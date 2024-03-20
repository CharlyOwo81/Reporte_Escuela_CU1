/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportesnegocios;

import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;
import org.itson.bdavanzadas.reportespersistencia.IReportesDAO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaValidar implements IFachadaValidar {
    
    private IReportesDAO reportesDAO ;
    
    public FachadaValidar(IReportesDAO reportesDAO) {
        this.reportesDAO = reportesDAO ;
    }

    @Override
    public Reporte validarReporte(ReporteNuevoDTO reporte) {
        return reportesDAO.validarReporte(reporte);
    }
    
}
