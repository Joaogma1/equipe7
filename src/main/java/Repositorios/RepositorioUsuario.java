/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Dominios.Usuario;
import Interfaces.InterfaceUsuario;
import Services.ConnectionFactory;
import Services.RepException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

            String sql = "SELECT * FROM TADSDISTRIBUIDORA.USUARIO  WHERE EMAIL = ? AND SENHA = ? AND ATIVO = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, email);
            pst.setString(2, senha);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                user = map(rs);
            }
            

        } catch (SQLException e) {
            throw new RepException("Operação não realizada com sucesso.", e);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Update(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Usuario map(ResultSet rs) throws SQLException{
        Usuario u = new Usuario();
        u.setId(rs.getInt("ID"));
        u.setEmail(rs.getString("EMAIL"));
        u.getIdTipoUsuario().setId(rs.getInt("ID_TIPO_USUARIO"));
        u.getIdUnidade().setId(rs.getInt("ID_UNIDADE"));
        return u;
    }

}
