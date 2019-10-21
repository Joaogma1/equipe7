/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Dominios.TipoUsuario;
import Dominios.UnidadeEmpresarial;
import Dominios.Usuario;
import Interfaces.InterfaceUsuario;
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
public class RepositorioUsuario implements InterfaceUsuario {

    public Usuario buscarPorEmailSenha(String email, String senha) {
        Connection con = null;
        Usuario user = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, UE.ID AS ID_UNIDADE_EMPRESARIAL, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                    + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID WHERE EMAIL = ? AND SENHA = ? AND ATIVO = 1";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = map(rs);
            }

        } catch (SQLException e) {
            throw new RepException("Operação não realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("Não foi possível fechar a conexão.", e);
            }
        }
        return user;
    }

    public void Add(Usuario obj) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.USUARIO(EMAIL,SENHA,ID_TIPO_USUARIO,ID_UNIDADE)VALUES(?,?,ID_TIPO_USUARIO,ID_UNIDADE,ATIVO);";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getEmail());
            pst.setString(2, obj.getSenha());
            pst.setInt(3, obj.getidCargo());
            pst.setInt(4, obj.getIdUnidadeEmp());

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

    public Usuario GetById(int id) {
        Connection con = null;
        Usuario user = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, UE.ID AS ID_UNIDADE_EMPRESARIAL, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                    + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID WHERE U.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = map(rs);
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
        return user;
    }

    public List<Usuario> GetAll() {
        Connection con = null;
        List<Usuario> listaUser = new ArrayList<Usuario>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, UE.ID AS ID_UNIDADE_EMPRESARIAL, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                    + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaUser.add(map(rs));
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
        return listaUser;
    }

    public void Update(Usuario obj) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE TADSDISTRIBUIDORA.USUARIO SET EMAIL  = ?, SENHA  = ?, ID_TIPO_USUARIO =?, ID_UNIDADE=? WHERE ID  = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getEmail());
            pst.setString(2, obj.getSenha());

            pst.setInt(3, obj.getId());
            pst.setInt(4, obj.getId());
            
            pst.setInt(5, obj.getId());

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
            String sql = "DELETE from TADSDISTRIBUIDORA.USUARIO where TADSDISTRIBUIDORA.USUARIO.ID = ?";

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

    private Usuario map(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("ID"));
        u.setEmail(rs.getString("EMAIL"));
        u.setDataRegistro(rs.getDate("DATA_REGISTRO"));

        u.setidCargo(rs.getInt("ID_TIPOUSER"));
        u.setIdUnidadeEmp(rs.getInt("ID_UNIDADE_EMPRESARIAL"));

        UnidadeEmpresarial ue = new UnidadeEmpresarial(rs.getInt("ID_UNIDADE_EMPRESARIAL"), rs.getString("NOME_UNIDADE"));
        u.setIdUnidade(ue);

        TipoUsuario tu = new TipoUsuario(rs.getInt("ID_TIPOUSER"), rs.getString("NOME_TIPO_USUARIO"));
        u.setIdTipoUsuario(tu);
        return u;
    }

}