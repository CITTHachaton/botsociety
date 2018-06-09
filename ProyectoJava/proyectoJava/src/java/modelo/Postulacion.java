/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "postulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulacion.findAll", query = "SELECT p FROM Postulacion p")
    , @NamedQuery(name = "Postulacion.findByIdPostulacion", query = "SELECT p FROM Postulacion p WHERE p.idPostulacion = :idPostulacion")
    , @NamedQuery(name = "Postulacion.findByFecha", query = "SELECT p FROM Postulacion p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Postulacion.findByIdPersona", query = "SELECT p FROM Postulacion p WHERE p.idPersona = :idPersona")
    , @NamedQuery(name = "Postulacion.findByIdOferta", query = "SELECT p FROM Postulacion p WHERE p.idOferta = :idOferta")})
public class Postulacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_postulacion")
    private Integer idPostulacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_oferta")
    private int idOferta;

    public Postulacion() {
    }

    public Postulacion(Integer idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public Postulacion(Integer idPostulacion, Date fecha, int idPersona, int idOferta) {
        this.idPostulacion = idPostulacion;
        this.fecha = fecha;
        this.idPersona = idPersona;
        this.idOferta = idOferta;
    }

    public Integer getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(Integer idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idPostulacion != null ? idPostulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulacion)) {
            return false;
        }
        Postulacion other = (Postulacion) object;
        if ((this.idPostulacion == null && other.idPostulacion != null) || (this.idPostulacion != null && !this.idPostulacion.equals(other.idPostulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Postulacion[ idPostulacion=" + idPostulacion + " ]";
    }
    
}
