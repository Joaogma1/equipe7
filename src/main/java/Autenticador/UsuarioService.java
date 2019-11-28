package Autenticador;

import Dominios.Usuario;

public interface UsuarioService {

    Usuario findByUsername(String username);

}
