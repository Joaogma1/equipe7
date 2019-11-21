package Repositorios;

import Dominios.Funcionario;
import Dominios.Usuario;
import Interfaces.InterfaceFuncionario;
import Interfaces.InterfaceUsuario;
import Services.ConnectionFactory;
import Services.RepException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepositorioFuncionario implements InterfaceFuncionario {

    public void Add(Funcionario obj, int idfilial) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.FUNCIONARIO(CPF,NOME,SALARIO,ENDERECO_COMPLETO,TELEFONE,ID_USUARIO)VALUES(?,?,?,?,?,?);";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getCpf());
            pst.setString(2, obj.getNome());
            pst.setBigDecimal(3, obj.getSalario());
            pst.setString(4, obj.getEnderecoCompleto());
            pst.setString(5, obj.getTelefone());
            pst.setInt(6, obj.getIdUser());
            pst.execute();

        } catch (SQLException e) {
            InterfaceUsuario user = new RepositorioUsuario();
            user.Remove(obj.getIdUser());
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

    public Funcionario GetById(int id) {
        Connection con = null;
        Funcionario func = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT F.CPF, F.NOME, F.SALARIO, F.ENDERECO_COMPLETO, F.TELEFONE, F.ID_USUARIO FROM PRODUTO F WHERE F.ID=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                func = map(rs);
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
        return func;
    }

    public List<Funcionario> GetAll(int idFilial) {
        Connection con = null;
        List<Funcionario> listaFunc = new ArrayList<Funcionario>();
        try {
            con = ConnectionFactory.getConnection();
            if (idFilial != 4) {
                String sql = "SELECT U.ID_UNIDADE, F.CPF, F.NOME, F.SALARIO, F.ENDERECO_COMPLETO, F.TELEFONE, F.ID_USUARIO FROM FUNCIONARIO F INNER JOIN USUARIO U ON U.ID = F.ID_USUARIO WHERE ID_UNIDADE = ? ";
                
                
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, idFilial);
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                listaFunc.add(map(rs));
            }
            }else{

            String sql = "SELECT F.CPF, F.NOME, F.SALARIO, F.ENDERECO_COMPLETO, F.TELEFONE, F.ID_USUARIO FROM PRODUTO F";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaFunc.add(map(rs));
            }
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
        return listaFunc;
    }

    public void Update(Funcionario obj) {
        Connection con = null;
        Usuario user = new Usuario();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE FUNCIONARIO SET CPF  = ?, NOME = ?,SALARIO = ?,ENDERECO_COMPLETO = ?,TELEFONE = ?,ID_USUARIO = ? WHERE ID  = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getCpf());
            pst.setString(2, obj.getNome());
            pst.setBigDecimal(3, obj.getSalario());
            pst.setString(4, obj.getEnderecoCompleto());
            pst.setString(5, obj.getTelefone());

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
            String sql = "DELETE from FUNCIONARIO where FUNCIONARIO.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

        } catch (SQLException e) {
            System.out.println(new RepException("Operação não realizada com sucesso.", e));
            try {
                String sqlExc = "UPDATE FUNCIONARIO SET ATIVO = 0 where FUNCIONARIO.ID = ?";
                PreparedStatement pstExc = con.prepareStatement(sqlExc);
                pstExc.setInt(1, id);
                pstExc.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    private Funcionario map(ResultSet rs) throws SQLException {
        Funcionario f = new Funcionario();
        f.setId(rs.getInt(null));
        f.setCpf(rs.getString(null));
        f.setNome(rs.getString(null));
        f.setSalario(new BigDecimal(rs.getDouble(null)));
        f.setTelefone(rs.getString(null));

        return f;
    }

}
