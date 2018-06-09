/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "categoria_oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaOferta.findAll", query = "SELECT c FROM CategoriaOferta c")
    , @NamedQuery(name = "CategoriaOferta.findByIdCategoria", query = "SELECT c FROM CategoriaOferta c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "CategoriaOferta.findByNombreCategoria", query = "SELECT c FROM CategoriaOferta c WHERE c.nombreCategoria = :nombreCategoria")})
public class CategoriaOferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Size(max = 39)
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    public CategoriaOferta() {
    }

    public CategoriaOferta(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaOferta)) {
            return false;
        }
        CategoriaOferta other = (CategoriaOferta) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CategoriaOferta[ idCategoria=" + idCategoria + " ]";
    }
    
}
