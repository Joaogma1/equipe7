package Dominios;

import Dominios.Usuario;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(TipoUsuario.class)
public class TipoUsuario_ { 

    public static volatile SingularAttribute<TipoUsuario, String> nome;
    public static volatile SingularAttribute<TipoUsuario, List> papeis;
    public static volatile SingularAttribute<TipoUsuario, Integer> id;
    public static volatile CollectionAttribute<TipoUsuario, Usuario> usuarioCollection;
    public static volatile SingularAttribute<TipoUsuario, Integer> nivel;

}