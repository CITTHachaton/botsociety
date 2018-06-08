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
@Table(name = "comuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c")
    , @NamedQuery(name = "Comuna.findByIdComuna", query = "SELECT c FROM Comuna c WHERE c.idComuna = :idComuna")
    , @NamedQuery(name = "Comuna.findByNombreComina", query = "SELECT c FROM Comuna c WHERE c.nombreComina = :nombreComina")
    , @NamedQuery(name = "Comuna.findByIdProvincia", query = "SELECT c FROM Comuna c WHERE c.idProvincia = :idProvincia")})
public class Comuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comuna")
    private Integer idComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_comina")
    private String nombreComina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_provincia")
    private int idProvincia;

    public Comuna() {
    }

    public Comuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public Comuna(Integer idComuna, String nombreComina, int idProvincia) {
        this.idComuna = idComuna;
        this.nombreComina = nombreComina;
        this.idProvincia = idProvincia;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombreComina() {
        return nombreComina;
    }

    public void setNombreComina(String nombreComina) {
        this.nombreComina = nombreComina;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComuna != null ? idComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.idComuna == null && other.idComuna != null) || (this.idComuna != null && !this.idComuna.equals(other.idComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Comuna[ idComuna=" + idComuna + " ]";
    }
    
}
