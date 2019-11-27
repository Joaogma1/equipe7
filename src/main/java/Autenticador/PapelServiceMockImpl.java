package Autenticador;

import java.util.LinkedHashMap;
import java.util.Map;

public class PapelServiceMockImpl implements PapelService {

    private static Map<String, Papel> mapPapeis;

    private static boolean initialized = false;

    public PapelServiceMockImpl() {
        synchronized (PapelServiceMockImpl.class) {
            if (!initialized) {
                init();
                initialized = true;
            }
        }
    }

    private void init() {
        mapPapeis = new LinkedHashMap<>();
        mapPapeis.put("Administrativo", new Papel("Administrativo"));
        mapPapeis.put("Retaguarda", new Papel("Retaguarda"));
        mapPapeis.put("GOD", new Papel("TI"));
        mapPapeis.put("GOD", new Papel("Vendas"));
    }

    @Override
    public Papel findByNome(String nomePapel) {
        return mapPapeis.get(nomePapel);
    }
}
