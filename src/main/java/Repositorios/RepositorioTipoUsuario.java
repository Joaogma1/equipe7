package Repositorios;

import Dominios.TipoUsuario;
import Interfaces.InterfaceTipoUsuario;
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

public class RepositorioTipoUsuario implements InterfaceTipoUsuario {

    public void Add(TipoUsuario obj) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "insert into TIPO_USUARIO(NOME) VALUES ('?') ";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getNome());

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

    public TipoUsuario GetById(int id) {
        Connection con = null;
        TipoUsuario tipoUser = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "select ID, NOME from TIPO_USUARIO TU where TU.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                tipoUser = map(rs);
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
        return tipoUser;
    }

    public List<TipoUsuario> GetAll() {
        Connection con = null;
        List<TipoUsuario> listaTipoUser = new ArrayList<TipoUsuario>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "select ID, NOME from TIPO_USUARIO";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaTipoUser.add(map(rs));
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
        return listaTipoUser;
    }

    public void Update(TipoUsuario obj) {
                Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "update TIPO_USUARIO set NOME = ? WHERE TIPO_USUARIO.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1,obj.getNome());

            pst.setInt(2,obj.getId());
            
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
            String sql = "delete from TIPO_USUARIO where TIPO_USUARIO.ID = ?";

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

    private TipoUsuario map(ResultSet rs) throws SQLException {
        TipoUsuario tu = new TipoUsuario();
        tu.setId(rs.getInt("ID"));
        tu.setNome(rs.getString("NOME"));
        return tu;
    }
}
