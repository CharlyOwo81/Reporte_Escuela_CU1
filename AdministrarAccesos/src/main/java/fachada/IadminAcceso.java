package fachada;

import dto.UsuarioDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface IadminAcceso {
    public UsuarioDTO iniciarSesion(UsuarioDTO usuarioDTO);
}
