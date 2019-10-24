package Dominios;

import Dominios.ProdutoUnidade;
import Dominios.UnidadeEmpresarial;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-24T08:58:02")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, BigDecimal> preco;
    public static volatile SingularAttribute<Produto, Date> ultimaModificacao;
    public static volatile SingularAttribute<Produto, Boolean> disponibilidade;
    public static volatile SingularAttribute<Produto, UnidadeEmpresarial> idOrigem;
    public static volatile SingularAttribute<Produto, Integer> id;
    public static volatile SingularAttribute<Produto, String> nomeProduto;
    public static volatile CollectionAttribute<Produto, ProdutoUnidade> produtoUnidadeCollection;

}