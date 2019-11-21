package Dominios;

import Dominios.ItemVenda;
import Dominios.ProdutoUnidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-21T01:45:53")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, ProdutoUnidade> idProduto;
    public static volatile CollectionAttribute<Item, ItemVenda> itemVendaCollection;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, Integer> quantidade;

}