package Dominios;

import Dominios.Funcionario;
import Dominios.TipoUsuario;
import Dominios.UnidadeEmpresarial;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Integer> idCargo;
    public static volatile SingularAttribute<Usuario, Boolean> ativo;
    public static volatile SingularAttribute<Usuario, TipoUsuario> idTipoUsuario;
    public static volatile SingularAttribute<Usuario, Date> dataRegistro;
    public static volatile CollectionAttribute<Usuario, Funcionario> funcionarioCollection;
    public static volatile SingularAttribute<Usuario, UnidadeEmpresarial> idUnidade;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, Integer> IdUnidadeEmp;
    public static volatile SingularAttribute<Usuario, String> email;

}