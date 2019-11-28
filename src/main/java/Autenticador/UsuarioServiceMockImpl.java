package Autenticador;
import Dominios.Usuario;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
public class UsuarioServiceMockImpl implements UsuarioService {
    private static Map<String, Usuario> mapUsuarios;
    private static boolean initialized = false;
    private PapelService papelService;
    public UsuarioServiceMockImpl() {
        synchronized (UsuarioServiceMockImpl.class) {
            if (!initialized) {
                papelService = new PapelServiceMockImpl();
                init();
                initialized = true;
            }
        }
    }
    private void init() {
        mapUsuarios = new LinkedHashMap<>();        
    }
    @Override
    public Usuario findByUsername(String username) {
        return mapUsuarios.get(username);
    }
}
