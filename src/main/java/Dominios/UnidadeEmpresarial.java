/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "UNIDADE_EMPRESARIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeEmpresarial.findAll", query = "SELECT u FROM UnidadeEmpresarial u"),
    @NamedQuery(name = "UnidadeEmpresarial.findById", query = "SELECT u FROM UnidadeEmpresarial u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadeEmpresarial.findByNomeUnidade", query = "SELECT u FROM UnidadeEmpresarial u WHERE u.nomeUnidade = :nomeUnidade")})
public class UnidadeEmpresarial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOME_UNIDADE")
    private String nomeUnidade;
    @OneToMany(mappedBy = "idOrigem")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidade")
    private Collection<ProdutoUnidade> produtoUnidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidade")
    private Collection<Usuario> usuarioCollection;

    public UnidadeEmpresarial() {
    }

    public UnidadeEmpresarial(Integer id) {
        this.id = id;
    }

    public UnidadeEmpresarial(Integer id, String nomeUnidade) {
        this.id = id;
        this.nomeUnidade = nomeUnidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<ProdutoUnidade> getProdutoUnidadeCollection() {
        return produtoUnidadeCollection;
    }

    public void setProdutoUnidadeCollection(Collection<ProdutoUnidade> produtoUnidadeCollection) {
        this.produtoUnidadeCollection = produtoUnidadeCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
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
        if (!(object instanceof UnidadeEmpresarial)) {
            return false;
        }
        UnidadeEmpresarial other = (UnidadeEmpresarial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominios.UnidadeEmpresarial[ id=" + id + " ]";
    }
    
}
