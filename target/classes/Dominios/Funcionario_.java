package Dominios;

import Dominios.Usuario;
import Dominios.Venda;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, Integer> idUser;
    public static volatile SingularAttribute<Funcionario, String> telefone;
    public static volatile SingularAttribute<Funcionario, BigDecimal> salario;
    public static volatile SingularAttribute<Funcionario, Usuario> idUsuario;
    public static volatile SingularAttribute<Funcionario, String> cpf;
    public static volatile SingularAttribute<Funcionario, String> nome;
    public static volatile SingularAttribute<Funcionario, Integer> id;
    public static volatile SingularAttribute<Funcionario, String> enderecoCompleto;
    public static volatile CollectionAttribute<Funcionario, Venda> vendaCollection;

}