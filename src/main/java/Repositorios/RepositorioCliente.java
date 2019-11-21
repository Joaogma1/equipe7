package Repositorios;

import Dominios.Cliente;
import Interfaces.InterfaceCliente;
import Services.RepException;
import Services.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioCliente implements InterfaceCliente {

    public void Add(Cliente obj, int idfilial) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.CLIENTE(CNPJ,EMAIL,TELEFONE,LOGRADOURO,ESTADO)VALUES(?,?,?,?,?) ";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getCnpj());
            pst.setString(2, obj.getEmail());
            pst.setString(3, obj.getTelefone());
            pst.setString(4, obj.getLogradouro());
            pst.setString(5, obj.getEstado());

            pst.execute();

        } catch (SQLException e) {
            throw new RepException("Operação não realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioCliente.class.getName()).log(Level.SEVERE, null, ex);
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

    public Cliente GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> GetAll(int idFilial) {

        Connection con = null;
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT ID,CNPJ,EMAIL,TELEFONE,LOGRADOURO,ESTADO FROM TADSDISTRIBUIDORA.CLIENTE;";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaCliente.add(map(rs));
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
        return listaCliente;
    }

    public void Update(Cliente obj) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE TADSDISTRIBUIDORA.CLIENTE SET CNPJ = ?,EMAIL = ?,TELEFONE = ?,LOGRADOURO = ?,ESTADO = ? WHERE ID = ?;";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getCnpj());
            pst.setString(2, obj.getEmail());
            pst.setString(3, obj.getTelefone());
            pst.setString(4, obj.getLogradouro());
            pst.setString(5, obj.getEstado());
            pst.setInt(6, obj.getId());

            pst.execute();

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

    public void Remove(int id) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TADSDISTRIBUIDORA.CLIENTEWHERE CLIENTE.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

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

    private Cliente map(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("ID"));
        cliente.setCnpj(rs.getString("CNPJ"));
        cliente.setEmail(rs.getString("EMAIL"));
        cliente.setTelefone(rs.getString("TELEFONE"));
        cliente.setLogradouro(rs.getString("LOGRADOURO"));
        cliente.setEstado(rs.getString("ESTADO"));
        return cliente;
    }

}
