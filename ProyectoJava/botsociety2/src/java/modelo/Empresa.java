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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Empresa.findByRutEmpresa", query = "SELECT e FROM Empresa e WHERE e.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "Empresa.findByImagenEmpresa", query = "SELECT e FROM Empresa e WHERE e.imagenEmpresa = :imagenEmpresa")
    , @NamedQuery(name = "Empresa.findByIdRubro", query = "SELECT e FROM Empresa e WHERE e.idRubro = :idRubro")
    , @NamedQuery(name = "Empresa.findByIdStand", query = "SELECT e FROM Empresa e WHERE e.idStand = :idStand")
    , @NamedQuery(name = "Empresa.findByIdControlE", query = "SELECT e FROM Empresa e WHERE e.idControlE = :idControlE")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Size(max = 100)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 30)
    @Column(name = "rut_empresa")
    private String rutEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "imagen_empresa")
    private String imagenEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rubro")
    private int idRubro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_stand")
    private int idStand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_control_e")
    private int idControlE;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String imagenEmpresa, int idRubro, int idStand, int idControlE) {
        this.idEmpresa = idEmpresa;
        this.imagenEmpresa = imagenEmpresa;
        this.idRubro = idRubro;
        this.idStand = idStand;
        this.idControlE = idControlE;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getImagenEmpresa() {
        return imagenEmpresa;
    }

    public void setImagenEmpresa(String imagenEmpresa) {
        this.imagenEmpresa = imagenEmpresa;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public int getIdControlE() {
        return idControlE;
    }

    public void setIdControlE(int idControlE) {
        this.idControlE = idControlE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
