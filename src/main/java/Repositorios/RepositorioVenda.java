//package Repositorios;
/*
import Dominios.Cliente;
import Dominios.ItemVenda;
import Dominios.Venda;
import Interfaces.InterfaceCliente;
import Interfaces.InterfaceVenda;
import Services.RepException;
import Services.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioVenda implements InterfaceVenda {

    public void Add(Venda obj, int idfilial) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.VENDA(COMPRADOR,VENDEDOR,METODO_PAGAMENTO,VALOR_TOTAL,idItem)VALUES(?,?,?,?,?) ";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getCliente());
            pst.setString(2, obj.getFuncionario();
            pst.setString(3, obj.getMetodoPagamento());
            pst.setBigDecimal(4, obj.getValorTotal());
            pst.setArray(5, obj.getItemVendaCollection());

            pst.execute();

        } catch (SQLException e) {
            throw new RepException("Operação não realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public Venda GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Venda> GetAll(int idFilial) {

        Connection con = null;
        List<Venda> listaVenda = new ArrayList<Venda>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT ID,DATA_VENDA,COMPRADOR,VENDEDOR,METODO_PAGAMENTO,VALOR_TOTAL,idItem FROM TADSDISTRIBUIDORA.VENDA;";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaVenda.add(map(rs));
            }

        } catch (SQLException e) {
            throw new RepException("Operação não realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("Não foi possível fechar a conexão.", e);
            }
        }
        return listaVenda;
    }



    private Venda map(ResultSet rs) throws SQLException {
        Venda venda = new Venda();
        venda.setId(rs.getInt("ID"));
        venda.setDataVenda(rs.getDate("DATA_VENDA"));
        venda.setCliente(rs.getString("COMPRADOR"));
        venda.setFuncionario(rs.getString("VENDEDOR"));
        venda.setMetodoPagamento(rs.getString("METODO_PAGAMENTO"));
        venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        venda.setItemVendaCollection((Collection<ItemVenda>) rs.getArray("idItem"));
        return venda;
    }

}
