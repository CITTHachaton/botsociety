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
@Table(name = "like_general")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikeGeneral.findAll", query = "SELECT l FROM LikeGeneral l")
    , @NamedQuery(name = "LikeGeneral.findByIdLikeG", query = "SELECT l FROM LikeGeneral l WHERE l.idLikeG = :idLikeG")
    , @NamedQuery(name = "LikeGeneral.findByIdPersona", query = "SELECT l FROM LikeGeneral l WHERE l.idPersona = :idPersona")
    , @NamedQuery(name = "LikeGeneral.findByPositivo", query = "SELECT l FROM LikeGeneral l WHERE l.positivo = :positivo")
    , @NamedQuery(name = "LikeGeneral.findByNegativo", query = "SELECT l FROM LikeGeneral l WHERE l.negativo = :negativo")})
public class LikeGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_like_g")
    private Integer idLikeG;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;
    @Column(name = "positivo")
    private Integer positivo;
    @Column(name = "negativo")
    private Integer negativo;

    public LikeGeneral() {
    }

    public LikeGeneral(Integer idLikeG) {
        this.idLikeG = idLikeG;
    }

    public LikeGeneral(Integer idLikeG, int idPersona) {
        this.idLikeG = idLikeG;
        this.idPersona = idPersona;
    }

    public Integer getIdLikeG() {
        return idLikeG;
    }

    public void setIdLikeG(Integer idLikeG) {
        this.idLikeG = idLikeG;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getPositivo() {
        return positivo;
    }

    public void setPositivo(Integer positivo) {
        this.positivo = positivo;
    }

    public Integer getNegativo() {
        return negativo;
    }

    public void setNegativo(Integer negativo) {
        this.negativo = negativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLikeG != null ? idLikeG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikeGeneral)) {
            return false;
        }
        LikeGeneral other = (LikeGeneral) object;
        if ((this.idLikeG == null && other.idLikeG != null) || (this.idLikeG != null && !this.idLikeG.equals(other.idLikeG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.LikeGeneral[ idLikeG=" + idLikeG + " ]";
    }
    
}
