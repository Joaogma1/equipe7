
package Repositorios;

import Dominios.Funcionario;
import Interfaces.InterfaceFuncionario;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RepositorioFuncionario implements InterfaceFuncionario{

    public void Add(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Funcionario GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Funcionario> GetAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Update(Funcionario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private Funcionario map(ResultSet rs) throws SQLException {
        Funcionario f = new Funcionario();
        f.setId(rs.getInt(null));
        f.setCpf(rs.getString(null));
        f.setNome(rs.getString(null));
        f.setSalario( new BigDecimal(rs.getDouble(null)));
        f.setTelefone(rs.getString(null));
        
        
        
        return f;
    }
    
}
