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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "stand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stand.findAll", query = "SELECT s FROM Stand s")
    , @NamedQuery(name = "Stand.findByIdStand", query = "SELECT s FROM Stand s WHERE s.idStand = :idStand")
    , @NamedQuery(name = "Stand.findByNumStand", query = "SELECT s FROM Stand s WHERE s.numStand = :numStand")})
public class Stand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_stand")
    private Integer idStand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_stand")
    private int numStand;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Area idArea;

    public Stand() {
    }

    public Stand(Integer idStand) {
        this.idStand = idStand;
    }

    public Stand(Integer idStand, int numStand) {
        this.idStand = idStand;
        this.numStand = numStand;
    }

    public Integer getIdStand() {
        return idStand;
    }

    public void setIdStand(Integer idStand) {
        this.idStand = idStand;
    }

    public int getNumStand() {
        return numStand;
    }

    public void setNumStand(int numStand) {
        this.numStand = numStand;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStand != null ? idStand.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stand)) {
            return false;
        }
        Stand other = (Stand) object;
        if ((this.idStand == null && other.idStand != null) || (this.idStand != null && !this.idStand.equals(other.idStand))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Stand[ idStand=" + idStand + " ]";
    }
    
}
