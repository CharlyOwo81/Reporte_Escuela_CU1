/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import control.SistemaMensajeria;

/**
 *
 * @author gamaliel
 */
public class FachadaSistemaMensajeria implements IFachadaSistemaMensajeria{
    private SistemaMensajeria boSistemaMensajeria;

    public FachadaSistemaMensajeria() {
        boSistemaMensajeria = new SistemaMensajeria();
    }

    @Override
    public void enviarMensaje() {
        return boSistemaMensajeria.enviarMensaje();
    }
    
    
}
