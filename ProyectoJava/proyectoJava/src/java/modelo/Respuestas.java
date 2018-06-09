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
@Table(name = "respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestas.findAll", query = "SELECT r FROM Respuestas r")
    , @NamedQuery(name = "Respuestas.findByIdRespuesta", query = "SELECT r FROM Respuestas r WHERE r.idRespuesta = :idRespuesta")
    , @NamedQuery(name = "Respuestas.findByRespuesta", query = "SELECT r FROM Respuestas r WHERE r.respuesta = :respuesta")
    , @NamedQuery(name = "Respuestas.findByIdPostulacion", query = "SELECT r FROM Respuestas r WHERE r.idPostulacion = :idPostulacion")
    , @NamedQuery(name = "Respuestas.findByIdPregunta", query = "SELECT r FROM Respuestas r WHERE r.idPregunta = :idPregunta")})
public class Respuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_respuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_postulacion")
    private int idPostulacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta")
    private int idPregunta;

    public Respuestas() {
    }

    public Respuestas(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuestas(Integer idRespuesta, String respuesta, int idPostulacion, int idPregunta) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;
        this.idPostulacion = idPostulacion;
        this.idPregunta = idPregunta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(int idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestas)) {
            return false;
        }
        Respuestas other = (Respuestas) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Respuestas[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
