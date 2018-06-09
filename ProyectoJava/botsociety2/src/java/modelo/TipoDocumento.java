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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByIdTipoD", query = "SELECT t FROM TipoDocumento t WHERE t.idTipoD = :idTipoD")
    , @NamedQuery(name = "TipoDocumento.findByNombreTipoD", query = "SELECT t FROM TipoDocumento t WHERE t.nombreTipoD = :nombreTipoD")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_d")
    private Integer idTipoD;
    @Size(max = 100)
    @Column(name = "nombre_tipo_d")
    private String nombreTipoD;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idTipoD) {
        this.idTipoD = idTipoD;
    }

    public Integer getIdTipoD() {
        return idTipoD;
    }

    public void setIdTipoD(Integer idTipoD) {
        this.idTipoD = idTipoD;
    }

    public String getNombreTipoD() {
        return nombreTipoD;
    }

    public void setNombreTipoD(String nombreTipoD) {
        this.nombreTipoD = nombreTipoD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoD != null ? idTipoD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipoD == null && other.idTipoD != null) || (this.idTipoD != null && !this.idTipoD.equals(other.idTipoD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoDocumento[ idTipoD=" + idTipoD + " ]";
    }
    
}
