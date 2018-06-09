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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "control_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlUsuario.findAll", query = "SELECT c FROM ControlUsuario c")
    , @NamedQuery(name = "ControlUsuario.findByIdControlU", query = "SELECT c FROM ControlUsuario c WHERE c.idControlU = :idControlU")
    , @NamedQuery(name = "ControlUsuario.findByUsuario", query = "SELECT c FROM ControlUsuario c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ControlUsuario.findByClave", query = "SELECT c FROM ControlUsuario c WHERE c.clave = :clave")
    , @NamedQuery(name = "ControlUsuario.findByRutPersona", query = "SELECT c FROM ControlUsuario c WHERE c.rutPersona = :rutPersona")
    , @NamedQuery(name = "ControlUsuario.findByIdPersona", query = "SELECT c FROM ControlUsuario c WHERE c.idPersona = :idPersona")})
public class ControlUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_u")
    private Integer idControlU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "clave")
    private String clave;
    @Size(max = 13)
    @Column(name = "rut_persona")
    private String rutPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;

    public ControlUsuario() {
    }

    public ControlUsuario(Integer idControlU) {
        this.idControlU = idControlU;
    }

    public ControlUsuario(Integer idControlU, String usuario, String clave, int idPersona) {
        this.idControlU = idControlU;
        this.usuario = usuario;
        this.clave = clave;
        this.idPersona = idPersona;
    }

    public Integer getIdControlU() {
        return idControlU;
    }

    public void setIdControlU(Integer idControlU) {
        this.idControlU = idControlU;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(String rutPersona) {
        this.rutPersona = rutPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlU != null ? idControlU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlUsuario)) {
            return false;
        }
        ControlUsuario other = (ControlUsuario) object;
        if ((this.idControlU == null && other.idControlU != null) || (this.idControlU != null && !this.idControlU.equals(other.idControlU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ControlUsuario[ idControlU=" + idControlU + " ]";
    }
    
}
