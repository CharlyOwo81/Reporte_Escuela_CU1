package fachada;

import control.CtrlAdminAcceso;
import dto.UsuarioDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class FachadaAdminAcceso implements IadminAcceso{

    @Override
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO) {
        return CtrlAdminAcceso.iniciarSesion(usuarioDTO);
    }

}
