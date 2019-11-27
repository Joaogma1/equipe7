
package Dominios;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    ,
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    ,
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    ,
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    ,
    @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo")
    ,
    @NamedQuery(name = "Usuario.findByDataRegistro", query = "SELECT u FROM Usuario u WHERE u.dataRegistro = :dataRegistro")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @Column(name = "DATA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Funcionario> funcionarioCollection;
    @JoinColumn(name = "ID_UNIDADE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeEmpresarial idUnidade;
    @JoinColumn(name = "ID_TIPO_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;

    private int idCargo;

    private int IdUnidadeEmp;
    private List<TipoUsuario> tipous;

    public int getidCargo() {
        return idCargo;
    }

    public void setidCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdUnidadeEmp() {
        return IdUnidadeEmp;
    }

    public void setIdUnidadeEmp(int IdUnidadeEmp) {
        this.IdUnidadeEmp = IdUnidadeEmp;
    }

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public UnidadeEmpresarial getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(UnidadeEmpresarial idUnidade) {
        this.idUnidade = idUnidade;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    public boolean verificarPapel(String nomeCargo) {
        for (TipoUsuario t : tipous) {
            if (t.getNome().equals(nomeCargo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dominios.Usuario[ id=" + id + " ]";
    }

}
