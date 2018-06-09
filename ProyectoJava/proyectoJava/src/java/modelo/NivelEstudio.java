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
@Table(name = "nivel_estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEstudio.findAll", query = "SELECT n FROM NivelEstudio n")
    , @NamedQuery(name = "NivelEstudio.findByIdNivelE", query = "SELECT n FROM NivelEstudio n WHERE n.idNivelE = :idNivelE")
    , @NamedQuery(name = "NivelEstudio.findByNombreNivelE", query = "SELECT n FROM NivelEstudio n WHERE n.nombreNivelE = :nombreNivelE")})
public class NivelEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel_e")
    private Integer idNivelE;
    @Size(max = 70)
    @Column(name = "nombre_nivel_e")
    private String nombreNivelE;

    public NivelEstudio() {
    }

    public NivelEstudio(Integer idNivelE) {
        this.idNivelE = idNivelE;
    }

    public Integer getIdNivelE() {
        return idNivelE;
    }

    public void setIdNivelE(Integer idNivelE) {
        this.idNivelE = idNivelE;
    }

    public String getNombreNivelE() {
        return nombreNivelE;
    }

    public void setNombreNivelE(String nombreNivelE) {
        this.nombreNivelE = nombreNivelE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelE != null ? idNivelE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEstudio)) {
            return false;
        }
        NivelEstudio other = (NivelEstudio) object;
        if ((this.idNivelE == null && other.idNivelE != null) || (this.idNivelE != null && !this.idNivelE.equals(other.idNivelE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.NivelEstudio[ idNivelE=" + idNivelE + " ]";
    }
    
}
