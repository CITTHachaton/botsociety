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
@Table(name = "likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l")
    , @NamedQuery(name = "Likes.findByIdLikes", query = "SELECT l FROM Likes l WHERE l.idLikes = :idLikes")
    , @NamedQuery(name = "Likes.findByIdPersona", query = "SELECT l FROM Likes l WHERE l.idPersona = :idPersona")
    , @NamedQuery(name = "Likes.findByIdOferta", query = "SELECT l FROM Likes l WHERE l.idOferta = :idOferta")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_likes")
    private Integer idLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oferta")
    private int idOferta;

    public Likes() {
    }

    public Likes(Integer idLikes) {
        this.idLikes = idLikes;
    }

    public Likes(Integer idLikes, int idPersona, int idOferta) {
        this.idLikes = idLikes;
        this.idPersona = idPersona;
        this.idOferta = idOferta;
    }

    public Integer getIdLikes() {
        return idLikes;
    }

    public void setIdLikes(Integer idLikes) {
        this.idLikes = idLikes;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
        hash += (idLikes != null ? idLikes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.idLikes == null && other.idLikes != null) || (this.idLikes != null && !this.idLikes.equals(other.idLikes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Likes[ idLikes=" + idLikes + " ]";
    }
    
}
