/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.reportesnegocios;

import java.util.List;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportespersistencia.IReportesDAO;

/**
 *
 * @author Oliver Valle
 */
public class FachadaRecuperar implements IFachadaRecuperar {
    
    private IReportesDAO reportesDAO ;
    
    public FachadaRecuperar(IReportesDAO reportesDAO) {
        this.reportesDAO = reportesDAO ;
    }

    @Override
    public List<Reporte> recuperarReportes() {
        return reportesDAO.recuperarReportes() ;
    }
    
}
