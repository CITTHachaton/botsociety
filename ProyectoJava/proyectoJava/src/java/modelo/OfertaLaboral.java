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
@Table(name = "oferta_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaLaboral.findAll", query = "SELECT o FROM OfertaLaboral o")
    , @NamedQuery(name = "OfertaLaboral.findByIdOferta", query = "SELECT o FROM OfertaLaboral o WHERE o.idOferta = :idOferta")
    , @NamedQuery(name = "OfertaLaboral.findByNombreOferta", query = "SELECT o FROM OfertaLaboral o WHERE o.nombreOferta = :nombreOferta")
    , @NamedQuery(name = "OfertaLaboral.findByVacantes", query = "SELECT o FROM OfertaLaboral o WHERE o.vacantes = :vacantes")
    , @NamedQuery(name = "OfertaLaboral.findByIdEmpresa", query = "SELECT o FROM OfertaLaboral o WHERE o.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "OfertaLaboral.findByGlosa", query = "SELECT o FROM OfertaLaboral o WHERE o.glosa = :glosa")
    , @NamedQuery(name = "OfertaLaboral.findByIdComuna", query = "SELECT o FROM OfertaLaboral o WHERE o.idComuna = :idComuna")})
public class OfertaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private Integer idOferta;
    @Size(max = 50)
    @Column(name = "nombre_oferta")
    private String nombreOferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vacantes")
    private int vacantes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private int idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "glosa")
    private String glosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comuna")
    private int idComuna;

    public OfertaLaboral() {
    }

    public OfertaLaboral(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public OfertaLaboral(Integer idOferta, int vacantes, int idEmpresa, String glosa, int idComuna) {
        this.idOferta = idOferta;
        this.vacantes = vacantes;
        this.idEmpresa = idEmpresa;
        this.glosa = glosa;
        this.idComuna = idComuna;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaLaboral)) {
            return false;
        }
        OfertaLaboral other = (OfertaLaboral) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.OfertaLaboral[ idOferta=" + idOferta + " ]";
    }
    
}
