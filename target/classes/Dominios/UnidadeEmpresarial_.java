package Dominios;

import Dominios.Produto;
import Dominios.ProdutoUnidade;
import Dominios.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-14T21:34:21")
@StaticMetamodel(UnidadeEmpresarial.class)
public class UnidadeEmpresarial_ { 

    public static volatile SingularAttribute<UnidadeEmpresarial, String> nomeUnidade;
    public static volatile CollectionAttribute<UnidadeEmpresarial, Produto> produtoCollection;
    public static volatile SingularAttribute<UnidadeEmpresarial, Integer> id;
    public static volatile CollectionAttribute<UnidadeEmpresarial, Usuario> usuarioCollection;
    public static volatile CollectionAttribute<UnidadeEmpresarial, ProdutoUnidade> produtoUnidadeCollection;

}