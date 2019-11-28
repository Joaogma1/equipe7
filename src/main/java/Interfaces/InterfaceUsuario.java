
package Interfaces;

import Dominios.Venda;
import Dominios.Usuario;
public interface InterfaceUsuario extends InterfaceBase<Usuario> {
    Usuario buscarPorEmailSenha(String email, String senha);
    int cadastraUsuario(Usuario user);
}
