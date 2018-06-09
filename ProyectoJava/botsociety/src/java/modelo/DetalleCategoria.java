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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "detalle_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCategoria.findAll", query = "SELECT d FROM DetalleCategoria d")
    , @NamedQuery(name = "DetalleCategoria.findByIdDetalleCategoria", query = "SELECT d FROM DetalleCategoria d WHERE d.idDetalleCategoria = :idDetalleCategoria")
    , @NamedQuery(name = "DetalleCategoria.findByIdCategoria", query = "SELECT d FROM DetalleCategoria d WHERE d.idCategoria = :idCategoria")
    , @NamedQuery(name = "DetalleCategoria.findByIdOferta", query = "SELECT d FROM DetalleCategoria d WHERE d.idOferta = :idOferta")})
public class DetalleCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_categoria")
    private Integer idDetalleCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria")
    private int idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oferta")
    private int idOferta;

    public DetalleCategoria() {
    }

    public DetalleCategoria(Integer idDetalleCategoria) {
        this.idDetalleCategoria = idDetalleCategoria;
    }

    public DetalleCategoria(Integer idDetalleCategoria, int idCategoria, int idOferta) {
        this.idDetalleCategoria = idDetalleCategoria;
        this.idCategoria = idCategoria;
        this.idOferta = idOferta;
    }

    public Integer getIdDetalleCategoria() {
        return idDetalleCategoria;
    }

    public void setIdDetalleCategoria(Integer idDetalleCategoria) {
        this.idDetalleCategoria = idDetalleCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCategoria != null ? idDetalleCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCategoria)) {
            return false;
        }
        DetalleCategoria other = (DetalleCategoria) object;
        if ((this.idDetalleCategoria == null && other.idDetalleCategoria != null) || (this.idDetalleCategoria != null && !this.idDetalleCategoria.equals(other.idDetalleCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleCategoria[ idDetalleCategoria=" + idDetalleCategoria + " ]";
    }
    
}
