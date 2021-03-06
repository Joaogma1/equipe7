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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                user = mapLogin(rs);
            }

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
        return user;
    }

    public void Add(Usuario obj, int idfilial) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.USUARIO(EMAIL,SENHA,ID_TIPO_USUARIO,ID_UNIDADE)VALUES(?,?,?,?);";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getEmail());
            pst.setString(2, obj.getSenha());
            pst.setInt(3, obj.getidCargo());
            pst.setInt(4, obj.getIdUnidadeEmp());

            pst.execute();

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
    }

    public Usuario GetById(int id) {
        Connection con = null;
        Usuario user = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, TU.NIVEL_ACESSO, UE.ID AS ID_UNIDADE_EMPRESARIAL, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                    + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID WHERE U.ID = ? AND ATIVO = 1";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user = map(rs);
            }

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
        return user;
    }

    public List<Usuario> GetAll(int idFilial) {
        Connection con = null;
        List<Usuario> listaUser = new ArrayList<Usuario>();
        try {
            con = ConnectionFactory.getConnection();
            if (idFilial != 4) {
                String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, UE.ID AS ID_UNIDADE_EMPRESARIAL,U.SENHA, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                        + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID WHERE ATIVO = 1 AND U.ID_UNIDADE = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, idFilial);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    listaUser.add(map(rs));
                }
            } else {
                String sql = "SELECT U.ID, EMAIL,TU.ID AS ID_TIPOUSER, TU.NOME AS NOME_TIPO_USUARIO, UE.ID AS ID_UNIDADE_EMPRESARIAL,U.SENHA, UE.NOME_UNIDADE, U.DATA_REGISTRO\n"
                        + "FROM TADSDISTRIBUIDORA.USUARIO U INNER JOIN TIPO_USUARIO TU ON U.ID_TIPO_USUARIO = TU.ID INNER JOIN UNIDADE_EMPRESARIAL UE ON U.ID_UNIDADE = UE.ID WHERE ATIVO = 1";

                PreparedStatement pst = con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    listaUser.add(map(rs));
                }
            }

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
        return listaUser;
    }

    public void Update(Usuario obj) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE TADSDISTRIBUIDORA.USUARIO SET EMAIL = ?, SENHA = ?, ID_TIPO_USUARIO = ?, ID_UNIDADE = ? WHERE ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, obj.getEmail());
            pst.setString(2, obj.getSenha());
            pst.setInt(3, obj.getidCargo());
            pst.setInt(4, obj.getIdUnidadeEmp());

            pst.setInt(5, obj.getId());

            pst.execute();

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
    }

    public void Remove(int id) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "UPDATE USUARIO SET ATIVO = 0 where USUARIO.ID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

        } catch (SQLException e) {
            System.out.println(new RepException("Opera��o n�o realizada com sucesso.", e));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
    }

    private Usuario map(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("ID"));
        u.setEmail(rs.getString("EMAIL"));
        u.setDataRegistro(rs.getDate("DATA_REGISTRO"));
        u.setSenha(rs.getString("SENHA"));

        u.setidCargo(rs.getInt("ID_TIPOUSER"));
        u.setIdUnidadeEmp(rs.getInt("ID_UNIDADE_EMPRESARIAL"));

        UnidadeEmpresarial ue = new UnidadeEmpresarial(rs.getInt("ID_UNIDADE_EMPRESARIAL"), rs.getString("NOME_UNIDADE"));
        u.setIdUnidade(ue);

        TipoUsuario tu = new TipoUsuario(rs.getInt("ID_TIPOUSER"), rs.getString("NOME_TIPO_USUARIO"));
        u.setIdTipoUsuario(tu);

        return u;
    }

    private Usuario mapLogin(ResultSet rs) throws SQLException {
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

    public int cadastraUsuario(Usuario user) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();

            String sql = "INSERT INTO TADSDISTRIBUIDORA.USUARIO(EMAIL,SENHA,ID_TIPO_USUARIO,ID_UNIDADE)VALUES(?,?,?,?);";

            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getSenha());
            pst.setInt(3, user.getidCargo());
            pst.setInt(4, user.getIdUnidadeEmp());

            pst.executeUpdate();

            final ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RepException("Opera��o n�o realizada com sucesso.", e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioTipoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RepException("N�o foi poss�vel fechar a conex�o.", e);
            }
        }
        return 0;
    }

}
