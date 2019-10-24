package Dominios;

import Dominios.Item;
import Dominios.Produto;
import Dominios.UnidadeEmpresarial;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-24T08:58:02")
@StaticMetamodel(ProdutoUnidade.class)
public class ProdutoUnidade_ { 

    public static volatile SingularAttribute<ProdutoUnidade, Produto> idProduto;
    public static volatile CollectionAttribute<ProdutoUnidade, Item> itemCollection;
    public static volatile SingularAttribute<ProdutoUnidade, UnidadeEmpresarial> idUnidade;
    public static volatile SingularAttribute<ProdutoUnidade, Integer> id;
    public static volatile SingularAttribute<ProdutoUnidade, Integer> quantidade;

}