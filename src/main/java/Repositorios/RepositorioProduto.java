/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Dominios.Produto;
import Interfaces.InterfaceProduto;
import Services.ConnectionFactory;
import Services.RepException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class RepositorioProduto implements InterfaceProduto {

    public void Add(Produto obj, int idfilial) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            if (obj.getIdOrigemNav() != null) {
                String sql = "INSERT INTO TADSDISTRIBUIDORA.PRODUTO (PRECO,NOME_PRODUTO,ID_ORIGEM)VALUES(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setBigDecimal(1, obj.getPreco());
                pst.setString(2, obj.getNomeProduto());
                pst.setInt(3, obj.getIdOrigemNav());
                pst.execute();

            } else {
                String sql = "INSERT INTO TADSDISTRIBUIDORA.PRODUTO (PRECO,NOME_PRODUTO)VALUES(?,?)";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.setBigDecimal(1, obj.getPreco());
                pst.setString(2, obj.getNomeProduto());
                pst.execute();
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
    }

    public Produto GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produto> GetAll(int idFilial) {
        Connection con = null;
        List<Produto> listaProduto = new ArrayList<Produto>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT ID ,PRECO, NOME_PRODUTO AS NOME FROM TADSDISTRIBUIDORA.PRODUTO where DISPONIBILIDADE = 1";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaProduto.add(map(rs));
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
        return listaProduto;
    }

    public void Update(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Produto map(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getInt("ID"));
        p.setNomeProduto(rs.getString("NOME"));
        p.setPreco(rs.getBigDecimal("PRECO"));
        return p;
    }
}
