package Dominios;

import Dominios.Item;
import Dominios.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Integer> id;
    public static volatile SingularAttribute<ItemVenda, Venda> idItem;
    public static volatile SingularAttribute<ItemVenda, Item> idVenda;

}