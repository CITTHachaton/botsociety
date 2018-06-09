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
@Table(name = "control_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlEmpresa.findAll", query = "SELECT c FROM ControlEmpresa c")
    , @NamedQuery(name = "ControlEmpresa.findByIdControlE", query = "SELECT c FROM ControlEmpresa c WHERE c.idControlE = :idControlE")
    , @NamedQuery(name = "ControlEmpresa.findByUsuario", query = "SELECT c FROM ControlEmpresa c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ControlEmpresa.findByClave", query = "SELECT c FROM ControlEmpresa c WHERE c.clave = :clave")
    , @NamedQuery(name = "ControlEmpresa.findByRutEmpresa", query = "SELECT c FROM ControlEmpresa c WHERE c.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "ControlEmpresa.findByIdEmpresa", query = "SELECT c FROM ControlEmpresa c WHERE c.idEmpresa = :idEmpresa")})
public class ControlEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_e")
    private Integer idControlE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "clave")
    private String clave;
    @Size(max = 30)
    @Column(name = "rut_empresa")
    private String rutEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private int idEmpresa;

    public ControlEmpresa() {
    }

    public ControlEmpresa(Integer idControlE) {
        this.idControlE = idControlE;
    }

    public ControlEmpresa(Integer idControlE, String usuario, String clave, int idEmpresa) {
        this.idControlE = idControlE;
        this.usuario = usuario;
        this.clave = clave;
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdControlE() {
        return idControlE;
    }

    public void setIdControlE(Integer idControlE) {
        this.idControlE = idControlE;
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

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlE != null ? idControlE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlEmpresa)) {
            return false;
        }
        ControlEmpresa other = (ControlEmpresa) object;
        if ((this.idControlE == null && other.idControlE != null) || (this.idControlE != null && !this.idControlE.equals(other.idControlE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ControlEmpresa[ idControlE=" + idControlE + " ]";
    }
    
}
