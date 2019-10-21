
package Dominios;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "PRODUTO_UNIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoUnidade.findAll", query = "SELECT p FROM ProdutoUnidade p"),
    @NamedQuery(name = "ProdutoUnidade.findById", query = "SELECT p FROM ProdutoUnidade p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoUnidade.findByQuantidade", query = "SELECT p FROM ProdutoUnidade p WHERE p.quantidade = :quantidade")})
public class ProdutoUnidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private Collection<Item> itemCollection;
    @JoinColumn(name = "ID_UNIDADE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeEmpresarial idUnidade;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public ProdutoUnidade() {
    }

    public ProdutoUnidade(Integer id) {
        this.id = id;
    }

    public ProdutoUnidade(Integer id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public UnidadeEmpresarial getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(UnidadeEmpresarial idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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
        if (!(object instanceof ProdutoUnidade)) {
            return false;
        }
        ProdutoUnidade other = (ProdutoUnidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominios.ProdutoUnidade[ id=" + id + " ]";
    }
    
}
