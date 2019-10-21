
package Dominios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByDisponibilidade", query = "SELECT p FROM Produto p WHERE p.disponibilidade = :disponibilidade"),
    @NamedQuery(name = "Produto.findByUltimaModificacao", query = "SELECT p FROM Produto p WHERE p.ultimaModificacao = :ultimaModificacao")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECO")
    private BigDecimal preco;
    @Basic(optional = false)
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Basic(optional = false)
    @Column(name = "DISPONIBILIDADE")
    private boolean disponibilidade;
    @Column(name = "ULTIMA_MODIFICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaModificacao;
    @JoinColumn(name = "ID_ORIGEM", referencedColumnName = "ID")
    @ManyToOne
    private UnidadeEmpresarial idOrigem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private Collection<ProdutoUnidade> produtoUnidadeCollection;

    public Produto() {
    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, BigDecimal preco, String nomeProduto, boolean disponibilidade) {
        this.id = id;
        this.preco = preco;
        this.nomeProduto = nomeProduto;
        this.disponibilidade = disponibilidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Date getUltimaModificacao() {
        return ultimaModificacao;
    }

    public void setUltimaModificacao(Date ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public UnidadeEmpresarial getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(UnidadeEmpresarial idOrigem) {
        this.idOrigem = idOrigem;
    }

    @XmlTransient
    public Collection<ProdutoUnidade> getProdutoUnidadeCollection() {
        return produtoUnidadeCollection;
    }

    public void setProdutoUnidadeCollection(Collection<ProdutoUnidade> produtoUnidadeCollection) {
        this.produtoUnidadeCollection = produtoUnidadeCollection;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominios.Produto[ id=" + id + " ]";
    }
    
}
