package Dominios;

import Dominios.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, String> estado;
    public static volatile SingularAttribute<Cliente, String> logradouro;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> cnpj;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile CollectionAttribute<Cliente, Venda> vendaCollection;

}