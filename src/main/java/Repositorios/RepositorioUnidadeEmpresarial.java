
package Repositorios;

import Dominios.UnidadeEmpresarial;
import Interfaces.InterfaceUnidadeEmpresarial;
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


public class RepositorioUnidadeEmpresarial implements InterfaceUnidadeEmpresarial{

    public void Add(UnidadeEmpresarial obj, int idfilial) {
                Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO UNIDADE_EMPRESARIAL(NOME_UNIDADE) VALUES(?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getNomeUnidade());

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

    public UnidadeEmpresarial GetById(int id) {
        Connection con = null;
        UnidadeEmpresarial uniEmp = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT ID, NOME_UNIDADE AS NOME FROM UNIDADE_EMPRESARIAL UE where UE.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                uniEmp = map(rs);
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
        return uniEmp;
    }

    public List<UnidadeEmpresarial> GetAll(int idFilial) {
        Connection con = null;
        List<UnidadeEmpresarial> listaUniEmp = new ArrayList<UnidadeEmpresarial>();
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT ID, NOME_UNIDADE AS NOME FROM UNIDADE_EMPRESARIAL";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaUniEmp.add(map(rs));
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
        return listaUniEmp;
    }

    public void Update(UnidadeEmpresarial obj) {
                Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE TADSDISTRIBUIDORA.UNIDADE_EMPRESARIAL SET NOME_UNIDADE = ? WHERE ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1,obj.getNomeUnidade());

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
            String sql = "delete from UNIDADE_EMPRESARIAL where UNIDADE_EMPRESARIAL.ID = ?";

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
    
        private UnidadeEmpresarial map(ResultSet rs) throws SQLException {
        UnidadeEmpresarial ue = new UnidadeEmpresarial();
        ue.setId(rs.getInt("ID"));
        ue.setNomeUnidade(rs.getString("NOME"));
        return ue;
    }
    
}
