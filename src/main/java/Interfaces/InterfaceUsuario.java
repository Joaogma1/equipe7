
package Interfaces;

import Dominios.Usuario;

/**
 *
 * @author Administrador
 */
public interface InterfaceUsuario extends InterfaceBase<Usuario> {
    Usuario buscarPorEmailSenha(String email, String senha);
}
