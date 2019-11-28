package Dominios;

import Dominios.Cliente;
import Dominios.Funcionario;
import Dominios.ItemVenda;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T15:23:08")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Date> dataVenda;
    public static volatile SingularAttribute<Venda, String> metodoPagamento;
    public static volatile CollectionAttribute<Venda, ItemVenda> itemVendaCollection;
    public static volatile SingularAttribute<Venda, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile SingularAttribute<Venda, Funcionario> funcionario;

}